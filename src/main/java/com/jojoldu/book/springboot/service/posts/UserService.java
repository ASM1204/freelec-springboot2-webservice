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
public class UserService {
    private final UserRepository2 userRepository2;

    @Transactional
    public Long buy(Long id, UserRequestDto requestDto) {
        User user = userRepository2.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        user.buy(requestDto.getItem_name(), requestDto.getBerry());
        return id;
    }


    public UserResponseDto findById(Long id) {
        User entity = userRepository2.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new UserResponseDto(entity);
    }


    @Transactional(readOnly = true)
    public List<UserResponseDto> findUser() {
        return userRepository2.findUser().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }
}