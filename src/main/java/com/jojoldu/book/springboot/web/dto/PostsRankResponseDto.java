package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsRankResponseDto {
    private Long id;
    private String catcherWin;
    private String catcherLose;
    private String runnerWin;
    private String runnerLose;


    public PostsRankResponseDto(User entity) {
        this.id = entity.getId();
        this.catcherWin = entity.getCatcherWin();
        this.catcherLose = entity.getCatcherLose();
        this.runnerWin = entity.getRunnerWin();
        this.runnerLose = entity.getRunnerLose();
    }
}
