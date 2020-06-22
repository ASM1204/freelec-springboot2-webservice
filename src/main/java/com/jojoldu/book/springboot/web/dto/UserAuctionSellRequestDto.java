package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserAuctionSellRequestDto {
    private String email;
    private int item_price;

    @Builder
    public UserAuctionSellRequestDto(String email, int item_price) {
        this.email = email;
        this.item_price = item_price;
    }
}
