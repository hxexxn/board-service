package com.board.www.service;

import java.util.List;

import com.board.www.model.Criteria;
import com.board.www.model.PostDTO;

public interface PostService {

    // 글 등록
    void post_write(PostDTO post);

    // 게시글 페이징 적용
    List<PostDTO> get_list_paging(Criteria cri);

    int get_total(Criteria cri);

    // 게시글 조회수 증가
    void post_view_count(String post_no);

    // 게시글 상세보기
    PostDTO post_select(String post_no);

    // 게시글 수정
    void post_update(PostDTO dto);

    // // 게시글 수정
    // void post_modify(String post_no);

    
}
