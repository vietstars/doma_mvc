package pwater.controller;

import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pwater.model.Account;
import pwater.entity.AccountEntity;


@Controller
public class Home {
	
	
    @RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        AccountEntity modelSelectAll = new AccountEntity();
    	List<Account> Accounts = modelSelectAll.selectAll();
    	model.addAttribute("accounts",Accounts);	
        return "_layout";
    }

}