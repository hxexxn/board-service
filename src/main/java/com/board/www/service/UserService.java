package com.board.www.service;

import com.board.www.model.UserDTO;

public interface UserService {

    // 유저 회원 가입
    void user_join(UserDTO userDTO);

    // 유저 회원 가입 - 아이디 중복 확인(Ajax)
    int user_id_check(String user_id);

    // 유저 회원 가입 - 닉네임 중복 확인(Ajax)
    int user_nick_check(String user_nick);

    // 유저 회원 가입 - 이메일 중복 확인(Ajax)
    int user_email_check(String user_email);

    // 유저 로그인
    UserDTO user_login(UserDTO user);


    
}
