package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class PostsRankResponseDto {
    private String name;
    private int catcher_win;
    private int catcher_lose;
    private int runner_win;
    private int runner_lose;


    public PostsRankResponseDto(User entity) {
        this.name = entity.getName();
        this.catcher_win = entity.getCatcher_win();
        this.catcher_lose = entity.getCatcher_lose();
        this.runner_win = entity.getRunner_win();
        this.runner_lose = entity.getRunner_lose();
    }
}
