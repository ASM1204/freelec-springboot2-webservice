package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.shop.Shop;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShopListResponseDto {
    private Long id;
    private String item_name;
    private String item_image;
    private String item_type;
    private String item_price;

    public ShopListResponseDto(Shop entity) {
        this.id = entity.getId();
        this.item_name = entity.getItem_name();
        this.item_image = entity.getItem_image();
        this.item_type = entity.getItem_type();
        this.item_price = entity.getItem_price();
    }
}
