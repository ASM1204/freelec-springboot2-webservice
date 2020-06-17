package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDto {
    private String item_name;
    private int item_berry;

    @Builder
    public UserRequestDto(String item_name, int item_berry) {
        this.item_name = item_name;
        this.item_berry = item_berry;
    }
}
