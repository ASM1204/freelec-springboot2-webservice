package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.shop.Shop;
import com.jojoldu.book.springboot.domain.shop.ShopRepository;
import com.jojoldu.book.springboot.domain.user.User;
import com.jojoldu.book.springboot.domain.user.UserRepository;
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
    private final UserRepository userRepository;

    @Transactional
    public Long buy(Long id, String email, ShopBuyRequestDto requestDto) {
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        User user = (User) userRepository.findUser(requestDto.getUser_email());
        user.buy(requestDto.getMy_item_count(),requestDto.getBerry());
        return id;
    }

    public ShopBuyResponseDto findById(Long id) {
        Shop entity = shopRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new ShopBuyResponseDto(entity);
    }
    public ShopBuyResponseDto findByEmail(String email) {
        Shop entity = (Shop) userRepository.findUser(email);
        return new ShopBuyResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ShopListResponseDto> findShop() {
        return shopRepository.findShop().stream()
                .map(ShopListResponseDto::new)
                .collect(Collectors.toList());
    }
}
