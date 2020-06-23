package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.notice.Notice;
import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class NoticeResponseDto {

    private Long notice_id;
    private String title;
    private String content;
    private String author;

    public NoticeResponseDto(Notice entity){
        this.notice_id=entity.getNotice_id();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.author=entity.getAuthor();
    }
}
