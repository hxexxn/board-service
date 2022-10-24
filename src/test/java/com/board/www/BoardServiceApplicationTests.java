package com.board.www;

import com.board.www.model.UserDTO;
import com.board.www.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class BoardServiceApplicationTests {

	@Autowired
	UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;


	// @Test
	@DisplayName("비밀번호 암호화 테스트")
	public void passwordTest() {

		String password = "Khe20120438!";
		String encode = passwordEncoder.encode(password);

		System.out.println(encode);
	}

//	@Test
	@DisplayName ("회원 가입 테스트")
	public void userJoinTest() {

		UserDTO user = new UserDTO();

		user.setUser_id("test");
		user.setUser_pw("Khe20120438!");
		user.setUser_nick("테스터");
		user.setUser_email("test@naver.com");

		userService.user_join(user);
	}

	// @Test
	@DisplayName("유저 아이디 중복 확인")
	public void userIdCheckTest() {

		String id = "test";

		int num = userService.user_id_check(id);

		if (num > 0) {
			System.out.println("사용 불가능한 아이디입니다.");
		} else {
			System.out.println("사용 가능한 아이디임");
		}
	}

//	@Test
	@DisplayName("유저 닉네임 중복 확인")
	public void userNickCheckTest() {

		String nick = "너굴";

		int num = userService.user_nick_check(nick);

		if (num > 0) {
			System.out.println("사용 불가능한 닉네임입니다.");
		} else {
			System.out.println("사용 가능한 닉네임임");
		}
	}

//	@Test
	@DisplayName("유저 이메일 중복 확인")
	public void userEmailCheckTest() {

		String email = "7395335@naver.com";

		int num = userService.user_email_check(email);

		if (num > 0) {
			System.out.println("이메일이 중복됨");
		} else {
			System.out.println("사용 가능한 email");
		}
	}

	@Test
	@DisplayName("로그인 테스트")
	public void userLoginCheck() {

		String id = "test2";
		String pw = "Test1234!";

		UserDTO userDTO = new UserDTO();

		userDTO.setUser_id(id);
		userDTO.setUser_pw(pw);

		userService.user_login(userDTO);
	}

}
