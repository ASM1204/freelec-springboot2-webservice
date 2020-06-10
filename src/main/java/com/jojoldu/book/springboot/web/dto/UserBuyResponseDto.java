package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.shop.Shop;
import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class UserBuyResponseDto {

    private Long id;
    private int smoke_bomb;
    private int berry;
    private String user_email;

    public UserBuyResponseDto(User entity){
        this.smoke_bomb = entity.getSmoke_bomb();
        this.user_email=entity.getEmail();
        this.berry = entity.getBerry();
    }
}
