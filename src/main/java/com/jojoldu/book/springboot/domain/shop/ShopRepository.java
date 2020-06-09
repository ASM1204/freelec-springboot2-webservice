package com.jojoldu.book.springboot.domain.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query("SELECT s FROM Shop s ORDER BY s.item_type DESC")
    List<Shop> findShop();

}
