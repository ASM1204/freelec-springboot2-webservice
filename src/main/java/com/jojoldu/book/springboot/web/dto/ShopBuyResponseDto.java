package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.shop.Shop;
import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class ShopBuyResponseDto {

    private Long item_id;
    private String item_name;
    private String item_image;
    private String item_type;
    private int item_price;
    private String user_email;

    public ShopBuyResponseDto(Shop entity){
        this.item_id = entity.getItem_id();
        this.item_name = entity.getItem_name();
        this.item_image = entity.getItem_image();
        this.item_type = entity.getItem_type();
        this.item_price = entity.getItem_price();
    }


}
