package pwater.controller;

import org.springframework.ui.Model;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import pwater.service.AccountService;
import pwater.form.RegisterForm;
import pwater.model.Account;


@Controller
public class Register {

    @Autowired
    private AccountService accountService;
		
    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String showRegister(
    	RegisterForm registerForm
    ) {	
        return "_layout";
    }
    
    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String checkRegister(
    	@RequestParam(required = false) String email,
    	@RequestParam(required = false) String password,
    	@RequestParam(required = false) String gender,
		@Valid RegisterForm registerForm, 
		BindingResult bindingResult,
		Model model
    ) {	
    	if (bindingResult.hasErrors()) {
            return "_layout";
        }else {
        	Account newAccount = new Account();
        	newAccount.setEmail(email);
        	newAccount.setPassword(password);
        	newAccount.setGender(gender);
            boolean created = accountService.newAccount(newAccount);
            model.addAttribute("registerError","Your email is exists!");
        	return created?"redirect:/home":"_layout";
        }
    }

}