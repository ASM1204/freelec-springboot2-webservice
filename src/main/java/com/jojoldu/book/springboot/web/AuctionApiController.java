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
    public Long save(@RequestBody AuctionSaveRequestDto requestDto) {
        return auctionService.auction_save(requestDto);
    }//save 등록 insert~~

    @PutMapping("/api/v1/auction")
    public String sell_item(@LoginUser SessionUser user, @RequestBody UserAuctionPostItemRequestDto requestDto) {
        return userService.sell_item(user.getEmail(), requestDto);
    }//아이템 판매등록해서 개수 수정

    @PutMapping("/api/v1/auction/{auction_id}")
    public String trade(@LoginUser SessionUser user, @RequestBody UserRequestDto requestDto) {
        return userService.buy(user.getEmail(), requestDto);
    }
    @PutMapping("/api/v1/auction/buy/{auction_id}")
    public Long sell(@PathVariable Long auction_id, @RequestBody UserAuctionSoldRequestDto requestDto) {
        return userService.sell(auction_id,requestDto);
    }//경매장에서 아이템 구매를 하였을때

    @DeleteMapping("/api/v1/posts/{auction_id}")
    public Long delete(@PathVariable Long auction_id) {
        auctionService.delete(auction_id);
        return auction_id;
    }

    @GetMapping("/api/v1/auction/list")
    public List<AuctionListResponseDto> findAllAuction() {
        return auctionService.findAllAuction();
    }
}
