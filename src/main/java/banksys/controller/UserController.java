package banksys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import banksys.dao.AccountDao;
import banksys.model.Account;
import banksys.model.User;

@Controller
@RequestMapping("user")
public class UserController {
	@RequestMapping("greet")
	public String greet(HttpServletRequest request, HttpServletResponse response, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
			return "redirect:/login/index";
		}
        
        List<Account> accountList= AccountDao.getUserAccount(user.getUserNo());
        model.addAttribute("user",user);
        model.addAttribute("accountList", accountList);
		return "user/greet";
	}
	
	@RequestMapping("tryAddAccount")
	public String tryAddAccount() {
		return "user/addAccount";
	}
	
	@RequestMapping("addAccount")
	public String addAccount(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("account_no") String account_no) {
		User user = (User) request.getSession().getAttribute("user");
        if (user == null) return "redirect:/login/index";
        
		Account account= AccountDao.getAccount(account_no);
		System.out.println(account);
		if (account.getAccountNo() == null) {
			System.out.println("addAccount");
	        AccountDao.addAccount(account_no, 1, user.getUserNo(), 0, "admin01");
			return "redirect:/user/greet";
		}
		else {
            request.setAttribute("add_account_msg", "同编号账户已存在!");
			return "forward:/user/tryAddAccount";
		}
	}
}
