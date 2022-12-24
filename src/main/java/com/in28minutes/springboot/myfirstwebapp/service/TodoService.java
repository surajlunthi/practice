package com.in28minutes.springboot.myfirstwebapp.service;

import com.in28minutes.springboot.myfirstwebapp.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {


    private static List<Todo> todos = new ArrayList<>();
    static{
    todos.add(new Todo(1,"suraj","Learn AWS", LocalDate.now().plusYears(1),false));
    todos.add(new Todo(2,"suraj","full stack", LocalDate.now().plusYears(1),false));
    todos.add(new Todo(3,"suraj","Dev ops",LocalDate.now().plusYears(2),false));
    }

      public List<Todo> displayTodos(String username){
        return todos;
    }
}
