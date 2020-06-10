package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShopBuyRequestDto {
    private String item_name;
    private int item_price;

    @Builder
    public ShopBuyRequestDto(String item_name, int item_price) {
        this.item_name = item_name;
        this.item_price = item_price;
    }
}
