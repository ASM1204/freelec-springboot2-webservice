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

    @PutMapping("/api/v1/shop/{id}")
    public Long buy(@PathVariable Long id, @RequestBody ShopBuyRequestDto requestDto) {
        return shopService.buy(id, requestDto);
    }

    @PutMapping("/api/v1/shop/{id}")
    public Long update(@PathVariable Long id, @RequestBody ShopBuyRequestDto requestDto) {
        return shopService.buy(id, requestDto);
    }

    @GetMapping("/api/v1/shop/{id}")
    public ShopBuyResponseDto findById(@PathVariable Long id) {
        return shopService.findById(id);
    }

    @GetMapping("/api/v1/shop/list")
    public List<ShopListResponseDto> findShop() {
        return shopService.findShop();
    }
}
