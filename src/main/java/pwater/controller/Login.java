package pwater.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import pwater.service.AccountService;
import pwater.form.LoginForm;
import pwater.model.Account;

@Controller
public class Login {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(
    		LoginForm loginForm
    ) {    	
        return "_layout";
    }
    

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String checkLogin(
    	@RequestParam(required = false) String email,
    	@RequestParam(required = false) String password,
    	@RequestParam(required = false) String remmeber,
		@Valid LoginForm loginForm, 
		BindingResult bindingResult,
		Model model,
        HttpServletRequest req
    ) {	
    	if (bindingResult.hasErrors()) {
            return "_layout";
        }else {
            Account acc	= accountService.findByEmail(email);
            if(password.equals(acc.getPassword())) {
                HttpSession session = req.getSession();
                session.setAttribute("isLogin", true);
                session.setAttribute("loggedEmail", acc.getEmail());
                session.setAttribute("loggedId", acc.getId());
           		return "redirect:/home";
           	}else {
        		model.addAttribute("loginError","Your account's information is not found!");
        		return "_layout";
       	    }        	
        }
    }
}