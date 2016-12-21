package cn.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()
@RequestMapping(value="/customer")
public class CustomerController {

	@RequestMapping(value="/input",method={RequestMethod.GET,RequestMethod.POST})
	public String inputCustomer(){
		
		return "CustomerForm";
	}
	
	
	@RequestMapping(value="/delete")
	public String deleteCustomer(){
		return "message";
	}
	
	
}
