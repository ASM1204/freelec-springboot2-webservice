package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.posts.AuctionService;
import com.jojoldu.book.springboot.service.posts.ShopService;
import com.jojoldu.book.springboot.service.posts.UserService;
import com.jojoldu.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AuctionApiController {

    private final ShopService shopService;
    private final UserService userService;
    private final AuctionService auctionService;

    @PostMapping("/api/v1/auction")
    public Long save(@LoginUser SessionUser user, Long item_id, @RequestBody AuctionSaveRequestDto requestDto) {
        return auctionService.save(item_id, user.getEmail(),requestDto);
    }//save 등록 insert~~

    @PutMapping("/api/v1/auction")
    public String sell_item(@LoginUser SessionUser user, @RequestBody UserAuctionRequestDto requestDto) {
        return auctionService.sell_item(user.getEmail(), requestDto);
    }

    @GetMapping("/api/v1/auction/list")
    public List<AuctionListResponseDto> findAllAuction() {
        return auctionService.findAllAuction();
    }
}
