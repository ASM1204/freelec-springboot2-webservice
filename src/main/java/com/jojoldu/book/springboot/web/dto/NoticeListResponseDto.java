package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.notice.Notice;
import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoticeListResponseDto {
    private Long notice_id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public NoticeListResponseDto(Notice entity) {
        this.notice_id = entity.getNotice_id();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
