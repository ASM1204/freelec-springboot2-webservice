package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.shop.Shop;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShopListResponseDto {
    private String item_name;
    private String item_image;
    private String item_type;
    private int item_price;

    public ShopListResponseDto(Shop entity) {
        this.item_name = getItem_name();
        this.item_image = getItem_image();
        this.item_type = getItem_type();
        this.item_price = getItem_price();
    }
}
