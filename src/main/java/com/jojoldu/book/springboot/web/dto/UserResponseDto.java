package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.shop.Shop;
import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long id;
    private String user_email;
    private int berry;

    private int smoke_bomb;

    public UserResponseDto(User entity){
        this.id=entity.getId();
        this.user_email=entity.getEmail();
        this.berry = entity.getBerry();
        this.smoke_bomb = entity.getSmoke_bomb();
    }
}
