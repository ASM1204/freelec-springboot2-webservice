package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsRankListResponseDto {
    private Long id;
    private int catcherWin;
    private int catcherLose;
    private int runnerWin;
    private int runnerLose;

    public PostsRankListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.catcherWin = entity.getCatcherWin();
        this.catcherLose = entity.getCatcherLose();
        this.runnerWin = entity.getRunnerWin();
        this.runnerLose = entity.getRunnerLose();
    }
}
