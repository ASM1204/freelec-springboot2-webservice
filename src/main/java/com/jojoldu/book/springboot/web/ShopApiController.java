package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.ShopService;
import com.jojoldu.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ShopApiController {

    private final ShopService shopService;

    @PutMapping("/api/v1/shop/{item_id}")
    public Long buy(@PathVariable Long item_id, @RequestBody ShopBuyRequestDto requestDto) {
        return shopService.buy(item_id, requestDto);
    }

    @GetMapping("/api/v1/shop/{item_id}")
    public ShopBuyResponseDto findById(@PathVariable Long item_id) {
        return shopService.findById(item_id);
    }

    @GetMapping("/api/v1/shop/list")
    public List<ShopListResponseDto> findShop() {
        return shopService.findShop();
    }
}
