package banksys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import banksys.dao.UserDao;

@Controller
@RequestMapping("register")
public class RegisterController {
	
	@RequestMapping("index")
	public String register() {
		return "register";
	}
	
	@RequestMapping("doRegister")
	public String doRegister(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("user_no") String user_no,
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			@RequestParam("owner_id_card") String owner_id_card) {
	UserDao.addUser(user_no, 1, name, password, owner_id_card);	
    System.out.println("register");
	return "redirect:/login/index";
	}
}
