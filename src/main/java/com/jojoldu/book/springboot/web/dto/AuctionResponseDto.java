package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.user.Role;
import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class AuctionResponseDto {

    private Long user_id;
    private String name;
    private String email;
    private int smoke_bomb;
    private int smoke_bomb1;
    private int smoke_bomb2;
    private int smoke_bomb3;
    private int smoke_bomb4;
    private int smoke_bomb5;
    private int smoke_bomb13;

    public AuctionResponseDto(User entity){
        this.user_id = entity.getUser_id();
        this.email = entity.getEmail();
        this.name = entity.getName();
        this.smoke_bomb = entity.getSmoke_bomb();
        this.smoke_bomb1 = entity.getSmoke_bomb1();
        this.smoke_bomb2 = entity.getSmoke_bomb2();
        this.smoke_bomb3 = entity.getSmoke_bomb3();
        this.smoke_bomb4 = entity.getSmoke_bomb4();
        this.smoke_bomb5 = entity.getSmoke_bomb5();
        this.smoke_bomb13 = entity.getSmoke_bomb13();
    }
}
