package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.shop.Shop;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class ShopResponseDto {

    private Long id;
    private String item_name;
    private String item_image;
    private String item_type;
    private int item_price;

    public ShopResponseDto(Shop entity){
        this.id = getId();
        this.item_name = getItem_name();
        this.item_image = getItem_image();
        this.item_type = getItem_type();
        this.item_price = getItem_price();
    }
}
