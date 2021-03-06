package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.auction.Auction;
import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuctionSaveRequestDto {
    private String item_image;
    private String item_name;
    private String item_type;
    private int item_price;
    private String author;

    @Builder
    public AuctionSaveRequestDto(String item_name, String item_image, String item_type, int item_price, String author) {
        this.item_name = item_name;
        this.item_image = item_image;
        this.item_type = item_type;
        this.item_price = item_price;
        this.author = author;
    }

    public Auction toEntity() {
        return Auction.builder()
                .item_name(item_name)
                .item_image(item_image)
                .item_type(item_type)
                .item_price(item_price)
                .author(author)
                .build();
    }
}
