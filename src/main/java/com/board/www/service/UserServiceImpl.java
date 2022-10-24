package com.board.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.board.www.mapper.UserMapper;
import com.board.www.model.UserDTO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    // 유저 회원 가입
    @Override
    public void user_join(UserDTO userDTO) {
        
        System.out.println("비밀번호 암호화 활성 중");

        userDTO.setUser_pw(passwordEncoder.encode(userDTO.getUser_pw()));
        
        userMapper.user_join(userDTO);

        System.out.println("비밀번호 암호화 완료");

        
    }

    // 유저 회원 가입 - 아이디 중복 확인
    @Override
    public int user_id_check(String user_id) {
        
        System.out.println("유저 아이디 중복 확인 중");

        int id_count = userMapper.user_id_check(user_id);

        System.out.println("유저 아이디 중복 확인 완료");

        return id_count;
    }

    // 유저 회원 가입 - 닉네임 중복 확인
    @Override
    public int user_nick_check(String user_nick) {

        System.out.println("유저 닉네임 중복 확인 중");

        int nick_count = userMapper.user_nick_check(user_nick);

        System.out.println("유저 닉네임 중복 확인 완료");

        return nick_count;
    }

    // 유저 회원 가입 - 이메일 중복 확인
    @Override
    public int user_email_check(String user_email) {

        System.out.println("유저 이메일 중복 확인 중");

        int email_count = userMapper.user_email_check(user_email);

        System.out.println("유저 이메일 중복 확인 완료");

        return email_count;
    }

    // 로그인 - 아이디와 일치하는 비밀번호 찾기
    @Override
    public UserDTO user_login(UserDTO user) {
        
        String pw_result = userMapper.user_find_pw(user.getUser_id());

        System.out.println(pw_result);

        boolean pw_filter = passwordEncoder.matches(user.getUser_pw(), pw_result);

        if (pw_filter) {

            UserDTO result_user = userMapper.user_login(user.getUser_id());

            return result_user;
        } else {

            return null;
        }
    }


    
}
