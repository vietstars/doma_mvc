package pwater.controller;

import org.springframework.ui.Model;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import pwater.service.AccountService;
import pwater.form.UserForm;
import pwater.model.Account;

@Controller
@RequestMapping(path="/user")
public class User {

    @Autowired
    private AccountService accountService;

	@GetMapping(path={"/del","/del/{id}"})
	public String confirm(@PathVariable(required = false) Integer id, UserForm userForm, Model model) {
		if( id == null || (id).equals(0) ){
			return "redirect:/home";
		}else{
			Account account = accountService.findOne(id);
			model.addAttribute("account", account);
			model.addAttribute("view", "user");
			return "_layout";
		}
	}

	@PostMapping(path={"/del","/del/{id}"})
	public String del(@PathVariable(required = false) Integer id, @RequestParam(required = false) String email, UserForm userForm, Model model) {
		if( id == null || (id).equals(0) ){
			return "redirect:/home";
		}else{
			Account account = accountService.findOne(id);
			if(email.equals(account.getEmail())){
				System.out.println(accountService.delAccount(id));
				return "redirect:/home";
			}else{
				model.addAttribute("account", account);
				model.addAttribute("view", "user");
				return "_layout";
			}
		}
	}

}