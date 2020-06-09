package com.jojoldu.book.springboot.domain.item;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import com.jojoldu.book.springboot.domain.user.Role;
import com.jojoldu.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Item extends BaseTimeEntity {


    @Column(nullable = false)
    private String item_name;

    @Column(nullable = false)
    private String item_image;

    @Column(nullable = false)
    private String item_type;

    @Column(nullable = false)
    private String item_price;



    public Item Shop(String item_name, String item_image, String item_type, String item_price) {
        this.item_name = item_name;
        this.item_image = item_image;
        this.item_type = item_type;
        this.item_price = item_price;
        return this;
    }
}
