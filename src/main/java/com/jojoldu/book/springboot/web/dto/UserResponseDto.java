package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.shop.Shop;
import com.jojoldu.book.springboot.domain.user.Role;
import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
public class UserResponseDto {

    private Long user_id;
    private String name;
    private String email;
    private String picture;
    private Role role;
    private int catcher_win;
    private int catcher_lose;
    private int runner_win;
    private int runner_lose;
    private int berry;
    private int smoke_bomb;
    private int smoke_bomb1;
    private int smoke_bomb2;
    private int smoke_bomb3;
    private int smoke_bomb4;
    private int smoke_bomb5;
    private int smoke_bomb13;

    public UserResponseDto(User entity) {
        this.user_id = entity.getUser_id();
        this.email = entity.getEmail();
        this.name = entity.getName();
        this.picture = entity.getPicture();
        this.role = entity.getRole();
        this.catcher_win = entity.getCatcher_win();
        this.catcher_lose = entity.getCatcher_lose();
        this.runner_win = entity.getRunner_win();
        this.runner_lose = entity.getRunner_lose();
        this.berry = entity.getBerry();
        this.smoke_bomb = entity.getSmoke_bomb();
        this.smoke_bomb1 = entity.getSmoke_bomb1();
        this.smoke_bomb2 = entity.getSmoke_bomb2();
        this.smoke_bomb3 = entity.getSmoke_bomb3();
        this.smoke_bomb4 = entity.getSmoke_bomb4();
        this.smoke_bomb5 = entity.getSmoke_bomb5();
        this.smoke_bomb13 = entity.getSmoke_bomb13();
    }
}
