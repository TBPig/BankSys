package banksys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import banksys.dao.UserDao;
import banksys.model.User;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@RequestMapping("")
	public String login() {
		return "login";
	}
	
	@RequestMapping("doLogin")
	public String doLogin(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam("user_no") String user_no, 
			@RequestParam("password") String password
			) {
		User user = UserDao.getInfoByUserNo(user_no);
        System.out.println(String.format("user %s is loginning", user_no));
        
        if(user.getUserNo() == null) {
            System.out.println("login1");
            request.setAttribute("login_msg", "用户不存在!");
        	return "forward:/login/";
        }
        else if(!user.getPassword().equals(password)) {
            System.out.println(String.format("login2:%s != %s", user.getPassword(), password));
        	request.setAttribute("login_msg", "密码错误!");
            return "forward:/login/";
        }
        else {
    		return "redirect:/greet/";
        }
	}
	
	@RequestMapping("logout")
    public String loginOut(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("user");
        return "redirect:/login/login";
    }
 
}
