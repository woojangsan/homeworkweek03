package com.sparta.week3.service;

import com.sparta.week3.models.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Getter
@RequiredArgsConstructor
@Service
public class PostingService {

    private final PostingRepository postingRepository;


    @Transactional
    public void update(Long id, PostingRequestDto requestDto) {
       Posting posting = postingRepository.findById(id).orElseThrow(
        () -> new NullPointerException("게시물이 존재하지 않습니다.")
        );
       posting.update(requestDto);


    }
    public SingleResponse getSingleResponse(Long id){
        SingleResponse singleResponse = new SingleResponse();
        singleResponse.setData(postingRepository.findById(id).orElseThrow(
                () -> new NullPointerException("게시글이 없음")
        ));


        return singleResponse;
    }

    public ListResponse getListResponse() {
        ListResponse listResponse = new ListResponse();
        listResponse.setDataList(postingRepository.findAllByOrderByModifiedAtDesc());

        return listResponse;
    }
}
