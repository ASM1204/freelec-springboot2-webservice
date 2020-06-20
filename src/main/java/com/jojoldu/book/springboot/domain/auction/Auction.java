package com.jojoldu.book.springboot.domain.auction;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Auction extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auction_id;

    @Column(nullable = false)
    private String item_image;

    @Column(nullable = false)
    private String item_name;

    @Column(nullable = false)
    private String item_type;

    @Column(nullable = false)
    private int item_price;

    @Column(nullable = false)
    private String author;

    @Builder
    public Auction(String item_name, String item_image, String item_type, int item_price, String author) {
        this.item_name = item_name;
        this.item_image = item_image;
        this.item_type = item_type;
        this.item_price = item_price;
        this.author = author;
    }

}
