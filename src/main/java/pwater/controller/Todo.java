package pwater.controller;

import org.springframework.ui.Model;

import java.util.List;
// import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.validation.BindingResult;

// import pwater.service.AccountService;
import pwater.form.TodoForm;
import pwater.model.Job;

@Controller
@RequestMapping(path="/todo")
public class Todo {

    // @Autowired
    // private AccountService accountService;

	@GetMapping(path={"","/list"})
	public String taskList( TodoForm todoForm, Model model) {
		// Job account = accountService.findOne(id);
		// model.addAttribute("list", account);
		model.addAttribute("view", "todo");
		return "_layout";
	}

	// @PostMapping(path={"/del","/del/{id}"})
	// public String del(
	// 	@PathVariable(required = false) Integer id,
	// 	@RequestParam(required = false) String email,
	// 	@Valid UserForm userForm,
	// 	BindingResult bindingResult,
	// 	Model model
	// ) {
	// 	if( id == null || (id).equals(0) ){
	// 		return "redirect:/home";
	// 	}else{
	// 		Account account = accountService.findOne(id);
	// 		model.addAttribute("account", account);
	// 		model.addAttribute("view", "user");
	// 		if (bindingResult.hasErrors()) {
	//             return "_layout";
	//         }else {
	// 			model.addAttribute("confirmError","Your email is not correctly!");
	// 			if(email.equals(account.getEmail())){
	// 				boolean result = accountService.delAccount(id);
	// 				return result?"redirect:/home":"_layout";
	// 			}else{
	// 				return "_layout";
	// 			}
	// 		}
	// 	}
	// }

	// @GetMapping(path="/ban")
	// public String ban(
	// 	@RequestParam(required = false) Integer id
	// ) {
	// 	accountService.toggleBan(id);
	// 	return "redirect:/home";
	// }

}