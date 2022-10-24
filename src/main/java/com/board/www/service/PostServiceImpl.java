package com.board.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.www.mapper.PostMapper;
import com.board.www.model.Criteria;
import com.board.www.model.PostDTO;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostMapper postMapper;

    // 글 등록
    @Override
    public void post_write(PostDTO post) {
        
        postMapper.post_write(post);
    }

    // 게시판 페이징
    @Override
    public List<PostDTO> get_list_paging(Criteria cri) {
        return postMapper.get_list_paging(cri);
    }

    @Override
    public int get_total(Criteria cri) {
        return postMapper.get_total(cri);
    }

    // 게시글 조회수 증가
    @Override
    public void post_view_count(String post_no) {
        postMapper.post_view_count(post_no);
        
    }

    // 게시글 상세보기
    @Override
    public PostDTO post_select(String post_no) {
        return postMapper.post_select(post_no);
    }

    @Override
    public void post_update(PostDTO dto) {
        postMapper.post_update(dto);
        
    }

    // @Override
    // public void post_modify(String post_no) {
    //     // TODO Auto-generated method stub
        
    // }
    
}
