package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserAuctionSellRequestDto {
    private int item_price;

    @Builder
    public UserAuctionSellRequestDto(int item_price) {
        this.item_price = item_price;
    }
}
