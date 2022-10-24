package com.board.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.www.model.Criteria;
import com.board.www.model.PageMakerDTO;
import com.board.www.model.PostDTO;
import com.board.www.service.PostService;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping (value = "board")
public class BoardController {

    @Autowired
    PostService postService;

    
    // // 익게 페이지
    // @GetMapping(value = "/anonymous")
    // public String anonymous(Model model) {
    //     return "posts/anonymous_board";
    // }

    // 자게 페이지
    @GetMapping(value = "/freeboard")
    public String freeboard(Model model, Criteria cri) {

        List<PostDTO> postList = postService.get_list_paging(cri);
        int total = postService.get_total(cri);

        PageMakerDTO pageMake = new PageMakerDTO(cri, total);

        model.addAttribute("list", postList);
        model.addAttribute("pagaMaker", pageMake);

        return "posts/nickname_board";
    }
    
    // 글 등록 이동
    @GetMapping (value = "/write")
    public String write() {
        return "posts/board_write";
    }

    // 글 등록
    @PostMapping (value = "/write")
    public String nick_post_write(PostDTO post) {

        postService.post_write(post);

        return "redirect:/board/freeboard";
    }

    // 글 상세 페이지
    @GetMapping(value = "/view")
    public String view(@RequestParam("id") String post_no, Model model) {
        postService.post_view_count(post_no);
        PostDTO dto = postService.post_select(post_no);
        model.addAttribute("dto", dto);

        return "posts/post_view";
    };

    // 글 수정으로 들어가는 페이지
    @GetMapping(value = "/modify")
    public String modify(@RequestParam("id") String post_no, Model model) {
        PostDTO dto = postService.post_select(post_no);
        model.addAttribute("dto", dto);
        return "posts/post_modify";
    }

    // 글 수정
    @PostMapping(value = "/modify")
    public String post_modify(PostDTO dto) {
        postService.post_update(dto);
        return "redirect:/board/view?id=" + dto.getPost_no();
    }
    
}
