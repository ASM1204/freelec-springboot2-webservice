package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class PostsShopResponseDto {
    private String item_name;
    private String item_image;
    private String item_type;
    private String item_price;


    public PostsShopResponseDto(User entity) {
        this.item_name = entity.getItem_name();
        this.item_image = entity.getItem_image();
        this.item_type = entity.getItem_type();
        this.item_price = entity.getItem_price();
    }
}
