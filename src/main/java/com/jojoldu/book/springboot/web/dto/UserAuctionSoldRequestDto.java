package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserAuctionSoldRequestDto {
    private String author;
    private String item_name;
    private int item_berry;

    @Builder
    public UserAuctionSoldRequestDto(String author, int item_berry) {
        this.author = author;
        this.item_berry = item_berry;
    }
}
