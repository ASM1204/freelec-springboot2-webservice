package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class PostsRankResponseDto {
    private String name;
    private String catcherWin;
    private String catcherLose;
    private String runnerWin;
    private String runnerLose;


    public PostsRankResponseDto(User entity) {
        this.name = entity.getName();
        this.catcherWin = entity.getCatcherWin();
        this.catcherLose = entity.getCatcherLose();
        this.runnerWin = entity.getRunnerWin();
        this.runnerLose = entity.getRunnerLose();
    }
}
