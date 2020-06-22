package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserAuctionPostItemRequestDto {
    private String item_name;

    @Builder
    public UserAuctionPostItemRequestDto(String item_name) {
        this.item_name = item_name;
    }
}
