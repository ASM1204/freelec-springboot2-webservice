package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.domain.user.RankRepository;
import com.jojoldu.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RankService {
    private final RankRepository RankRepository;

    @Transactional(readOnly = true)
    public List<PostsRankResponseDto> findRank() {
        return RankRepository.findRank().stream()
                .map(PostsRankResponseDto::new)
                .collect(Collectors.toList());
    }

}
