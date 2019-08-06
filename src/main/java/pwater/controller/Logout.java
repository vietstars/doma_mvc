package pwater.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Logout {

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout(HttpServletRequest req) {  
        HttpSession session = req.getSession();
        session.invalidate();
        return "redirect:/home";
    }
    
}