package com.jojoldu.book.springboot.domain.shop;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Shop extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String item_name;

    @Column(nullable = false)
    private String item_image;

    @Column(nullable = false)
    private String item_type;

    @Column(nullable = false)
    private String item_price;



    @Builder
    public Shop(String item_name, String item_image, String item_type, String item_price) {
        this.item_name=item_name;
        this.item_image=item_image;
        this.item_type=item_type;
        this.item_price=item_price;
    }

    public void buy(String item_name, String item_price) {
        this.item_name=item_name;
        this.item_price=item_price;
    }
}
