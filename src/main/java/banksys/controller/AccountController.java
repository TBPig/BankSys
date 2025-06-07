package banksys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import banksys.dao.AccountDao;
import banksys.model.Account;
import banksys.model.User;

@Controller
@RequestMapping("account")
public class AccountController {
	
	@RequestMapping("save")
	public String save() {
		return "account/save";
	}
	
	@RequestMapping("doSave")
	public String doSave(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("account_no") String accountNo,
			@RequestParam("money") int money) {
		User user = (User) request.getSession().getAttribute("user");
        if (user == null) return "redirect:/login/index";
        
		Account account= AccountDao.getAccount(accountNo);
		if (account.getOpenerId() == null) {
            request.setAttribute("save_msg", "账号不存在！");
			return "forward:/account/save";
		}
		else if (!account.getOpenerId().equals(user.getUserNo())) {
            request.setAttribute("save_msg", "账号不属于你！");
			return "forward:/account/save";
		}
		else if (user.getStatus() != 1) {
            request.setAttribute("save_msg", "用户状态异常，不可存款");
			return "forward:/account/save";
		}
		else if (account.getStatus() != 1) {
            request.setAttribute("save_msg", "账户状态异常，不可存款");
			return "forward:/account/save";
		}
		else if (money <= 0) {
            request.setAttribute("save_msg", "金额需正整数！");
			return "forward:/account/save";
		}
		else {
			int balance = account.getBalance();
			balance += money;
			AccountDao.setBalance(accountNo, balance);
			return "redirect:/user/greet";
		}
	}
	
	@RequestMapping("draw")
	public String draw() {
		return "account/draw";
	}
	
	@RequestMapping("doDraw")
	public String doDraw(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("account_no") String accountNo,
			@RequestParam("money") int money) {
		User user = (User) request.getSession().getAttribute("user");
        if (user == null) return "redirect:/login/index";
        
		Account account= AccountDao.getAccount(accountNo);
		if (account.getOpenerId() == null) {
            request.setAttribute("draw_msg", "账号不存在！");
			return "forward:/account/draw";
		}
		else if (!account.getOpenerId().equals(user.getUserNo())) {
            request.setAttribute("draw_msg", "账号不属于你！");
			return "forward:/account/draw";
		}
		else if (user.getStatus() != 1) {
            request.setAttribute("draw_msg", "用户状态异常，不可存款");
			return "forward:/account/draw";
		}
		else if (account.getStatus() != 1) {
            request.setAttribute("draw_msg", "账户状态异常，不可存款");
			return "forward:/account/draw";
		}
		else if (money <= 0) {
            request.setAttribute("draw_msg", "金额需正整数！");
			return "forward:/account/draw";
		}
		else if (money > account.getBalance()) {
            request.setAttribute("draw_msg", "金额需不大于账户余额！");
			return "forward:/account/draw";
		}
		else {
			int balance = account.getBalance();
			balance -= money;
			AccountDao.setBalance(accountNo, balance);
			return "redirect:/user/greet";
		}
	}
}
