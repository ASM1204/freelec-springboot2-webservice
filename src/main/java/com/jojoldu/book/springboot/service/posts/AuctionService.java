package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.domain.auction.Auction;
import com.jojoldu.book.springboot.domain.auction.AuctionRepository;
import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.shop.Shop;
import com.jojoldu.book.springboot.domain.shop.ShopRepository;
import com.jojoldu.book.springboot.domain.user.User;
import com.jojoldu.book.springboot.domain.user.UserRepository;
import com.jojoldu.book.springboot.domain.user.UserRepository2;
import com.jojoldu.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AuctionService {
    private final ShopRepository shopRepository;
    private final UserRepository userRepository;
    private final UserRepository2 userRepository2;
    private final AuctionRepository auctionRepository;



    @Transactional
    public Long auction_save(AuctionSaveRequestDto requestDto) {
        return auctionRepository.save(requestDto.toEntity()).getAuction_id();
    }

    public AuctionListResponseDto findById(Long auction_id) {
        Auction entity = auctionRepository.findById(auction_id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + auction_id));
        return new AuctionListResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<AuctionListResponseDto> findAllAuction() {
        return auctionRepository.findAllAuction().stream()
                .map(AuctionListResponseDto::new)
                .collect(Collectors.toList());
    }
}
