package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class PostsRankResponseDto {
    private String name;
    private String catcher_win;
    private String catcher_lose;
    private String runner_win;
    private String runner_lose;


    public PostsRankResponseDto(User entity) {
        this.name = entity.getName();
        this.catcher_win = entity.getCatcher_win();
        this.catcher_lose = entity.getCatcher_lose();
        this.runner_win = entity.getRunner_win();
        this.runner_lose = entity.getRunner_lose();
    }
}
