package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.auction.Auction;
import com.jojoldu.book.springboot.domain.auction.AuctionRepository;
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
public class UserService {
    private final UserRepository2 userRepository2;
    private final UserRepository userRepository;
    private final AuctionRepository auctionRepository;

    @Transactional
    public String buy(String email, UserRequestDto requestDto) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + email));
        user.item_add(requestDto.getItem_name(), requestDto.getItem_berry());
        return email;
    }

//    @Transactional
//    public String sell(Long auction_id, UserAuctionSellRequestDto requestDto) {
//        Auction auction = auctionRepository.findById(auction_id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + auction_id));
//        User user = userRepository.findByEmail(auction.getAuthor()).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + auction.getAuthor()));
//        user.item_sell(requestDto.getItem_price());
//        return auction.getAuthor();
//    }

    public UserResponseDto findById(Long user_id) {
        User entity = userRepository2.findById(user_id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + user_id));
        return new UserResponseDto(entity);
    }

    public UserResponseDto findMy(String email) {
        User user_info = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + email));
        return new UserResponseDto(user_info);
    }

    @Transactional
    public String post_item(String email, UserAuctionPostItemRequestDto requestDto) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + email));
        user.select_item(requestDto.getItem_name());
        return email;
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findUser() {
        return userRepository2.findUser().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }
}
