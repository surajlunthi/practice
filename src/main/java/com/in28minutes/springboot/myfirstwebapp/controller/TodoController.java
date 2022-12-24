package com.in28minutes.springboot.myfirstwebapp.controller;


import com.in28minutes.springboot.myfirstwebapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;


@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "list-todos",method = RequestMethod.GET)
    public String displayTodos(ModelMap model){
        model.put("todos",todoService.displayTodos("suraj"));
        return "listTodos";
    }

}
