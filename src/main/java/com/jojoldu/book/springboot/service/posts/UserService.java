package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.shop.Shop;
import com.jojoldu.book.springboot.domain.shop.ShopRepository;
import com.jojoldu.book.springboot.domain.user.User;
import com.jojoldu.book.springboot.domain.user.UserRepository;
import com.jojoldu.book.springboot.domain.user.UserRepository2;
import com.jojoldu.book.springboot.domain.user.UserRepository3;
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
    private final UserRepository3 userRepository3;

    @Transactional
    public Long buy(Long user_id, UserRequestDto requestDto) {
        User user = userRepository2.findById(user_id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + user_id));
        user.buy(requestDto.getItem_name(), requestDto.getBerry());
        return user_id;
    }


    public UserResponseDto findById(Long user_id) {
        User entity = userRepository3.findById(user_id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + user_id));
        return new UserResponseDto(entity);
    }


    @Transactional(readOnly = true)
    public List<UserResponseDto> findUser() {
        return userRepository2.findUser().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }
}
