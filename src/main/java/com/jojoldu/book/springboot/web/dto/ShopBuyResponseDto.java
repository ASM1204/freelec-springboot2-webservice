package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.shop.Shop;
import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class ShopBuyResponseDto {

    private Long id;
    private String item_name;
    private int berry;
    private String user_email;

    public ShopBuyResponseDto(Shop entity){
        this.id = entity.getId();
        this.item_name = entity.getItem_name();
        this.berry = entity.getItem_price();
    }
    public ShopBuyResponseDto(User entity){
        this.id = entity.getId();
        this.user_email=entity.getEmail();
        this.berry = entity.getBerry();
    }
}
