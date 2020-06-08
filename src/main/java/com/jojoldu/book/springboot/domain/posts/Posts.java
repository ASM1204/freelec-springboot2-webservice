package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Column(nullable = false)
    private int catcherWin;
    private int catcherLose;
    private int runnerWin;
    private int runnerLose;

    @Builder
    public Posts(String title, String content, String author, int catcherWin, int catcherLose, int runnerWin, int runnerLose
                 ) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.catcherWin=catcherWin;
        this.catcherLose=catcherLose;
        this.runnerWin=runnerWin;
        this.runnerLose=runnerLose;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
