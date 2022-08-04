package com.sparta.week3.controller;

import com.sparta.week3.models.Posting;
import com.sparta.week3.models.PostingRepository;
import com.sparta.week3.models.PostingRequestDto;
import com.sparta.week3.service.PostingService;
import com.sparta.week3.models.ListResponse;
import com.sparta.week3.models.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequiredArgsConstructor
@RestController
public class PostingRestController {

    private final PostingRepository postingRepository;
    private final PostingService postingService;


//    @GetMapping("/api/postings")
//    public List<Posting> getPosting(){
//       return postingRepository.findAllByOrderByModifiedAtDesc();
//    }

    @GetMapping("/api/postings")
    public ListResponse getPosting(){
        return postingService.getListResponse();
    }

//    @GetMapping("/api/postings/{id}")
//    public Posting getPosting(@PathVariable Long id) {
//        Optional<Posting> byId = postingRepository.findById(id);
//        return byId.orElseThrow(
//                () -> new NullPointerException("게시물이 없음")
//        );
//    }

    @GetMapping("/api/postings/{id}")
    public SingleResponse getPosting(@PathVariable Long id) {
        return postingService.getSingleResponse(id);
    }

    @PostMapping("/api/postings")
    public Posting createPosting(@RequestBody PostingRequestDto requestDto) {
        Posting posting = new Posting(requestDto);
        return postingRepository.save(posting);

    }


    @PostMapping("/api/postings/{id}")
    public boolean createPassword(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new NullPointerException("게시글이 없습니다.")
        );
        return Objects.equals(posting.getPassword(), requestDto.getPassword());

    }

    @DeleteMapping("/api/postings/{id}")
    public Long deletePosting(@PathVariable Long id) {
        postingRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/postings/{id}")
    public PostingRequestDto updatePosting(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        postingService.update(id, requestDto);
        return requestDto;
    }
}
