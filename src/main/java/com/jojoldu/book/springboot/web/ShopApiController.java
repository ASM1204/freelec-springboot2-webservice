package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.posts.ShopService;
import com.jojoldu.book.springboot.service.posts.UserService;
import com.jojoldu.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ShopApiController {

    private final ShopService shopService;
    private final UserService userService;

    @PutMapping("/api/v1/shop/{item_id}")
    public String buy(@LoginUser SessionUser user, @RequestBody UserRequestDto requestDto) {
        return userService.buy(user.getEmail(), requestDto);
    }


//    @GetMapping("/api/v1/shop/{item_id}")
//    public UserResponseDto findEmail(@LoginUser SessionUser user) {
//        return userService.findMy(user.getEmail());
//    }

    @GetMapping("/api/v1/shop/list")
    public List<ShopListResponseDto> findShop() {
        return shopService.findShop();
    }
}
