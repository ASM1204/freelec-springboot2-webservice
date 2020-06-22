package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.domain.auction.Auction;
import com.jojoldu.book.springboot.domain.auction.AuctionRepository;
import com.jojoldu.book.springboot.domain.user.User;
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
    private final User user;
    private final AuctionRepository auctionRepository;

    @PostMapping("/api/v1/auction")
    public Long save(@RequestBody AuctionSaveRequestDto requestDto) {
        return auctionService.auction_save(requestDto);
    }//save 등록 insert~~

//    @PutMapping("/api/v1/auction")
//    public String post_item(@LoginUser SessionUser user, @RequestBody UserAuctionRequestDto requestDto) {
//        return userService.post_item(user.getEmail(), requestDto);
//    }//아이템 판매등록을 하여 해당 아이템 개수 수정

    @PutMapping("/api/v1/auction/buy/{auction_id}")
    public String buy(@LoginUser SessionUser user, @RequestBody UserRequestDto requestDto) {
        return userService.buy(user.getEmail(), requestDto);
    }
//    @PutMapping("/api/v1/auction/{auction_id}")
//    public String sell(@PathVariable Long auction_id, @RequestBody UserAuctionSellRequestDto requestDto) {
//        return userService.sell(auction_id, requestDto);
//    }
//    @DeleteMapping("/api/v1/auction/buy/{auction_id}")
//    public Long delete(@PathVariable Long auction_id) {
//        auctionService.delete(auction_id);
//        return auction_id;
//    }

    @GetMapping("/api/v1/auction/list")
    public List<AuctionListResponseDto> findAllAuction() {
        return auctionService.findAllAuction();
    }
}
