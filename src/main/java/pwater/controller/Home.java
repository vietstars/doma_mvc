package pwater.controller;

import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pwater.model.Account;

@Controller
@SuppressWarnings("unchecked")
public class Home {

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		Account accountList = new Account();
		List<Account> accounts = accountList.selectAll();
		model.addAttribute("accounts", accounts);
		return "_layout";
	}

}