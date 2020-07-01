package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.service.posts.UserService;
import com.jojoldu.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UnityApiController {

    private final UserService userService;

    @GetMapping("/unity")
    public String profile(@LoginUser SessionUser user) {

        String unity_my_user=user.getEmail();

        return unity_my_user;
//        return profiles.stream()
//                .filter(realProfiles::contains)
//                .findAny()
//                .orElse(defaultProfile);
    }
}
