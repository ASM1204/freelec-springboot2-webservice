package com.jojoldu.book.springboot.domain.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query("SELECT i FROM Shop i ORDER BY i.item_id DESC")
    List<Shop> findShop();

}
