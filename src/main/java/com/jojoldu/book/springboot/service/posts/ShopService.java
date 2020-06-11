package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.shop.Shop;
import com.jojoldu.book.springboot.domain.shop.ShopRepository;
import com.jojoldu.book.springboot.domain.user.User;
import com.jojoldu.book.springboot.domain.user.UserRepository;
import com.jojoldu.book.springboot.domain.user.UserRepository2;
import com.jojoldu.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShopService {
    private final ShopRepository shopRepository;
    private final UserRepository2 userRepository2;

    @Transactional
    public Long buy(Long item_id, ShopBuyRequestDto requestDto) {
        Shop shop = shopRepository.findById(item_id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + item_id));
        return item_id;
    }

    public ShopBuyResponseDto findById(Long item_id) {
        Shop entity = shopRepository.findById(item_id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + item_id));
        return new ShopBuyResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ShopListResponseDto> findShop() {
        return shopRepository.findShop().stream()
                .map(ShopListResponseDto::new)
                .collect(Collectors.toList());
    }
}
