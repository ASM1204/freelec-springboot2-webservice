package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.notice.Notice;
import com.jojoldu.book.springboot.domain.notice.NoticeRepository;
import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    @Transactional
    public Long save(NoticeSaveRequestDto requestDto) {
        return noticeRepository.save(requestDto.toEntity()).getNotice_id();
    }

    @Transactional
    public Long update(Long notice_id, NoticeUpdateRequestDto requestDto) {
        Notice notice = noticeRepository.findById(notice_id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + notice_id));
        notice.update(requestDto.getTitle(), requestDto.getContent());
        return notice_id;
    }

    public NoticeResponseDto findById(Long notice_id) {
        Notice entity = noticeRepository.findById(notice_id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + notice_id));
        return new NoticeResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<NoticeListResponseDto> findAllDesc() {
        return noticeRepository.findAllDesc().stream()
                .map(NoticeListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long notice_id) {
        Notice notice = noticeRepository.findById(notice_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + notice_id));

        noticeRepository.delete(notice);
    }
}
