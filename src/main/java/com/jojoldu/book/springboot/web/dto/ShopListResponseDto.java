package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.shop.Shop;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShopListResponseDto {

    private Long item_id;
    private String item_name;
    private String item_image;
    private String item_type;
    private int item_price;

    public ShopListResponseDto(Shop entity) {
        this.item_id = entity.getItem_id();
        this.item_name = entity.getItem_name();
        this.item_image = entity.getItem_image();
        this.item_type = entity.getItem_type();
        this.item_price = entity.getItem_price();
    }
}
