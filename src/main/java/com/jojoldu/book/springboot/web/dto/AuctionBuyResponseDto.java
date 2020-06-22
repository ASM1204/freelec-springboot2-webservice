package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.auction.Auction;
import com.jojoldu.book.springboot.domain.shop.Shop;
import lombok.Getter;

@Getter
public class AuctionBuyResponseDto {

    private Long auction_id;
    private String item_name;
    private String item_image;
    private String item_type;
    private int item_price;
    private String author;

    public AuctionBuyResponseDto(Auction entity){
        this.auction_id = entity.getAuction_id();
        this.item_name = entity.getItem_name();
        this.item_image = entity.getItem_image();
        this.item_type = entity.getItem_type();
        this.item_price = entity.getItem_price();
        this.author = entity.getAuthor();
    }


}
