package pwater.controller;

import org.springframework.ui.Model;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import pwater.service.AccountService;
import pwater.model.Account;

@Controller
@SuppressWarnings("unchecked")
public class Home {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		List<Account> accounts = accountService.selectAll();
		model.addAttribute("accounts", accounts);
		return "_layout";
	}

}