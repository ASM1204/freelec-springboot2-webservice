package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.config.auth.dto.OAuthAttributes;
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
public class UserService {
    private final UserRepository2 userRepository2;
    private final UserRepository userRepository;

    @Transactional
    public String buy(String email, UserRequestDto requestDto) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + email));
        user.item_add(requestDto.getItem_name(), requestDto.getItem_berry());
        return email;
    }

    @Transactional
    public String sell_get_berry(String email, UserAuctionSellRequestDto requestDto) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + email));
        user.item_sell_get_berry(requestDto.getItem_berry());
        return email;
    }

    public UserResponseDto findById(Long user_id) {
        User entity = userRepository2.findById(user_id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + user_id));
        return new UserResponseDto(entity);
    }

    public UserResponseDto findMy(String email) {
        User user_info = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + email));
        return new UserResponseDto(user_info);
    }

    @Transactional
    public String item_post(String email, UserAuctionPostItemRequestDto requestDto) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + email));
        user.item_post(requestDto.getItem_name());
        return email;
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findUser() {
        return userRepository2.findUser().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }
}
