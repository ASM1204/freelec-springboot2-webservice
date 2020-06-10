package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShopBuyRequestDto {
    private Long id;
    private String item_name;
    private String item_image;
    private String item_type;
    private int item_price;

    @Builder
    public ShopBuyRequestDto(String item_name, String item_image, String item_type, int item_price) {
        this.item_name = item_name;
        this.item_image = item_image;
        this.item_type = item_type;
        this.item_price = item_price;
    }
}
