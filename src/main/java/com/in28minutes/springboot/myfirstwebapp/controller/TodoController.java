package com.in28minutes.springboot.myfirstwebapp.controller;


import com.in28minutes.springboot.myfirstwebapp.model.Todo;
import com.in28minutes.springboot.myfirstwebapp.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;


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
    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String showTodo(ModelMap model){
        Todo todo = new Todo(0,(String) model.get("name"),"hello", LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo",method= RequestMethod.POST)
    public String addTodo(@Valid Todo todo, ModelMap model, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        } else {
            todoService.addTodo((String) model.get("name"), todo.getDescription(), LocalDate.now().plusYears(1), false);
            return "redirect:list-todos";
        }
    }
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam long id) {

        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo",method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam long id,ModelMap model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo",method = RequestMethod.POST)
    public String addUpdatedTodo(ModelMap model,@Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "todo";
        }

        String username = (String) model.get("name");

        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

}
