package com.in28minutes.springboot.myfirstwebapp.controller;

import com.in28minutes.springboot.myfirstwebapp.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private AuthenticateService authenticateService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String sayHello(@RequestParam String name, @RequestParam String password, ModelMap model) {

        if (authenticateService.isValidUser(name, password)) {
            model.put("name", name);
            model.put("password", password);
            return "welcome";
        } else {
            model.put("error","Your credential are not correct");
            return "sayHello";
        }
    }
}
