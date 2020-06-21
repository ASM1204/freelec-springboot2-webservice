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
    public String sell_item(String email, UserAuctionRequestDto requestDto) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + email));
        user.select_item(requestDto.getItem_name());
        return email;
    }

    @Transactional
    public Long save(Long item_id, String email, AuctionSaveRequestDto requestDto) {
        Shop entity = shopRepository.findById(item_id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + item_id));
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + email));
        requestDto.builder().entity(entity).user(user).build();
        return auctionRepository.save(requestDto.toEntity()).getAuction_id();
    }

    @Transactional(readOnly = true)
    public List<AuctionListResponseDto> findAllAuction() {
        return auctionRepository.findAllAuction().stream()
                .map(AuctionListResponseDto::new)
                .collect(Collectors.toList());
    }
}
