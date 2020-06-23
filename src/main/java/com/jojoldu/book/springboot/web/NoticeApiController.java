package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.NoticeService;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoticeApiController {

    private final NoticeService noticeService;

    @PostMapping("/api/v1/notice")
    public Long save(@RequestBody NoticeSaveRequestDto requestDto) {
        return noticeService.save(requestDto);
    }//save 등록 insert~~

    @PutMapping("/api/v1/notice/{notice_id}")
    public Long update(@PathVariable Long notice_id, @RequestBody NoticeUpdateRequestDto requestDto) {
        return noticeService.update(notice_id, requestDto);
    }

    @GetMapping("/api/v1/notice/{notice_id}")
    public NoticeResponseDto findById(@PathVariable Long notice_id) {
        return noticeService.findById(notice_id);
    }

    @DeleteMapping("/api/v1/notice/{notice_id}")
    public Long delete(@PathVariable Long notice_id) {
        noticeService.delete(notice_id);
        return notice_id;
    }
    @GetMapping("/api/v1/notice/list")
    public List<NoticeListResponseDto> findAll() {
        return noticeService.findAllDesc();
    }
}
