package com.board.www.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PostDTO {

    private int post_no;

    private String post_title;

    private String post_content;

    private int post_view;

    private Timestamp post_regdate;

    private String post_writer;
    
}
