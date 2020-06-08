package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsNickNameRequestDto {
    private String nickName;

    @Builder
    public PostsNickNameRequestDto(String nickName) {
        this.nickName = nickName;
    }
}
