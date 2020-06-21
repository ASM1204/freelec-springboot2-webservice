package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.auction.Auction;
import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.shop.Shop;
import com.jojoldu.book.springboot.domain.user.User;
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
    public AuctionSaveRequestDto(Shop entity, User user) {
        this.item_image = entity.getItem_image();
        this.item_name = entity.getItem_name();
        this.item_type = entity.getItem_type();
        this.item_price = entity.getItem_price();
        this.author = user.getName();
    }

    public Auction toEntity() {
        return Auction.builder()
                .item_image(item_image)
                .item_name(item_name)
                .item_type(item_type)
                .item_price(item_price)
                .author(author)
                .build();
    }
}
