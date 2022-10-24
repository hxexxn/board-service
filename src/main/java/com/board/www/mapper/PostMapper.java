package com.board.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.www.model.Criteria;
import com.board.www.model.PostDTO;

@Mapper
public interface PostMapper {

    // 글 등록
    void post_write(PostDTO post);

    // 게시판 페이징
    List<PostDTO> get_list_paging(Criteria cri);

    // 페이징 번호
    int get_total(Criteria cri);

    // 게시글 조회수 증가
    void post_view_count(String post_no);

    // 게시글 상세보기
    PostDTO post_select(String post_no);

    // 게시글 수정
    void post_update(PostDTO dto);
    
}
