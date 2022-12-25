package com.in28minutes.springboot.myfirstwebapp.service;

import com.in28minutes.springboot.myfirstwebapp.model.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TodoService {


    private static List<Todo> todos = new ArrayList<>();
    static{
    todos.add(new Todo(1,"suraj","Learn AWS", LocalDate.now().plusYears(1),false));
    todos.add(new Todo(2,"suraj","full stack", LocalDate.now().plusYears(1),false));
    todos.add(new Todo(3,"suraj","Dev ops",LocalDate.now().plusYears(2),false));
    }

     public void addTodo(String username,String description,LocalDate targetDate,boolean value){
     todos.add(new Todo(todos.size()+1,
             username,
             description,
             targetDate,
             value));
     }
      public List<Todo> displayTodos(String username){
        return todos;
    }


      public void deleteById(long id){
          Predicate<?super Todo> predicate =  todo->id == todo.getId();
          todos.removeIf(predicate);
      }
    public Todo findById(long id){
        Predicate<?super Todo> predicate =  todo->id == todo.getId();
        return todos.stream().filter(todo -> todo.getId()==id).findFirst().get();
    }

    public void updateTodo(@Valid Todo todo){
        deleteById(todo.getId());
        todos.add(todo);

        todos = todos.stream().sorted(Comparator.comparing(Todo::getId)).collect(Collectors.toList());
    }

}
