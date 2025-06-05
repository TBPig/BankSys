package banksys.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@RequestMapping("")
	public String login() {
        System.out.println("login");
		return "login";
	}
	
	@RequestMapping("doLogin")
	public String doLogin(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam("user_code") int user_code, 
			@RequestParam("password") String password
			) {
        System.out.println("dologin");
		return "forward:/login/";
	}
        
}
