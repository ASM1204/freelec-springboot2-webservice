package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.notice.Notice;
import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticeSaveRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public NoticeSaveRequestDto(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public Notice toEntity(){
        return Notice.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
