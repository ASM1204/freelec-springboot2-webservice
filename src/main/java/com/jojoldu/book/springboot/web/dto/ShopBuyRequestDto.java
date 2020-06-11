package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShopBuyRequestDto {
    private Long item_id;
    private int my_item_count;
    private int berry;
    private String user_email;

    @Builder
    public ShopBuyRequestDto(Long item_id, int my_item_count, int berry, String user_email) {
        this.item_id = item_id;
        this.my_item_count = my_item_count;
        this.berry = berry;
        this.user_email = user_email;
    }
}
