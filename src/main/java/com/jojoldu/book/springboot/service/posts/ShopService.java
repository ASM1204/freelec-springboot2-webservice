package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.domain.shop.Shop;
import com.jojoldu.book.springboot.domain.shop.ShopRepository;
import com.jojoldu.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShopService {
    private final ShopRepository shopRepository;

    @Transactional
    public Long buy(Long id, ShopBuyRequestDto requestDto) {
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        shop.buy(requestDto.getItem_name(), requestDto.getItem_price());
        return id;
    }

    public ShopResponseDto findById(Long id) {
        Shop entity = shopRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new ShopResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ShopListResponseDto> findShop() {
        return shopRepository.findShop().stream()
                .map(ShopListResponseDto::new)
                .collect(Collectors.toList());
    }
}
