package banksys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("greet")
public class GreetController {
	@RequestMapping("greet")
	public String greet() {
        System.out.println("greet");
		return "login";
	}
}
