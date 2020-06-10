package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.web.dto.PostsRankResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RankService {
    private final com.jojoldu.book.springboot.domain.user.RankRepository RankRepository;

    @Transactional(readOnly = true)
    public List<PostsRankResponseDto> findRank() {
        return RankRepository.findRank().stream()
                .map(PostsRankResponseDto::new)
                .collect(Collectors.toList());
    }

}
