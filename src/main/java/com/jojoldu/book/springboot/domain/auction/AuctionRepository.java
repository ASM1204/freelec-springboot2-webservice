package com.jojoldu.book.springboot.domain.auction;

import com.jojoldu.book.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.auction_id DESC")
    List<Auction> findAllAuction();

}
