package com.board.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.board.www.model.UserDTO;

@Mapper
public interface UserMapper {

    // 회원 가입
    void user_join(UserDTO userDTO);

    // 회원 가입 - 아이디 중복 확인
    int user_id_check(String user_id);

    // 회원 가입 - 닉네임 중복 확인
    int user_nick_check(String user_nick);

    // 회원 가입 - 이메일 중복 확인
    int user_email_check(String user_email);

    // 로그인 - 아이디와 일치하는 비밀번호 찾기
    String user_find_pw(String user_pw);

    // 로그인 - 최종
    UserDTO user_login(String user_id);


    
}
