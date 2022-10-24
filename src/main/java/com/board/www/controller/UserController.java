package com.board.www.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.www.model.UserDTO;
import com.board.www.service.UserService;

@Controller
@RequestMapping(value = "auth")
public class UserController {

    @Autowired
    UserService userService;

    // 회원 가입 페이지 이동
    @GetMapping(value = "/join")
    public String join() {
        return "user/user_join";
    }

    // 회원 가입
    @PostMapping(value = "/join")
    public String user_join(UserDTO userDTO) {

        System.out.printf("회원 가입 시도하는 중");

        userService.user_join(userDTO);

        System.out.printf("회원 가입 완료");

        return "redirect:/";
    }

    // 회원 가입 - 아이디 중복 확인 Ajax
    @ResponseBody
    @PostMapping(value = "/duplicate/user-id-check")
    public int user_id_check(@RequestParam("user_id") String user_id) {

        int id_count = userService.user_id_check(user_id);

        return id_count;
    }

    // 회원 가입 - 닉네임 중복 확인 Ajax
    @ResponseBody
    @PostMapping(value = "/duplicate/user-nick-check")
    public int user_nick_check(@RequestParam("user_nick") String user_nick) {

        int nick_count = userService.user_nick_check(user_nick);

        return nick_count;
    }

    // 회원 가입 - 이메일 중복 확인 Ajax
    @ResponseBody
    @PostMapping(value = "/duplicate/user-email-check")
    public int user_email_check(@RequestParam("user_email") String user_email) {

        int email_count = userService.user_email_check(user_email);

        return email_count;
    }

    // 로그인 페이지 이동
    @GetMapping(value = "/login")
    public String login() {
        return "user/user_login";
    }

    // 로그인
    @PostMapping(value = "/login")
    public String user_login(UserDTO user, HttpServletRequest request, Model model) {

        // int result_count = userService.user_login_ajax(userDTO);
        UserDTO result_user = userService.user_login(user);

        System.out.println(result_user.toString());

        if (user != null) {

            HttpSession session = request.getSession();

            session.setAttribute("user_no", result_user.getUser_no());
            session.setAttribute("user_id", result_user.getUser_id());
            session.setAttribute("user_nick", result_user.getUser_nick());
            session.setAttribute("user_email", result_user.getUser_email());
            session.setAttribute("user_regdate", result_user.getUser_regdate());

            System.out.println("로그인 성공 및 세션 등록 성공");

            return "redirect:/";

        } else {

            model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");

            return "user/user_login";
        }
    }



    // 로그인 실패
    // @GetMapping ("/login/error")
    // public String loginError(Model model) {
    //     model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
    //     return "user/user_login";

    // }


    // 로그아웃
    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession();

        session.invalidate();

        System.out.println("로그아웃 완료");

        return "redirect:/";
    }

}
