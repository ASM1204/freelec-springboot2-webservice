package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.item.ItemRepository;
import com.jojoldu.book.springboot.domain.user.RankRepository;
import com.jojoldu.book.springboot.web.dto.PostsRankResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsShopResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShopService {
    private final ItemRepository ItemRepository;

    @Transactional(readOnly = true)
    public List<PostsShopResponseDto> findItem() {
        return ItemRepository.findItem().stream()
                .map(PostsShopResponseDto::new)
                .collect(Collectors.toList());
    }

}
