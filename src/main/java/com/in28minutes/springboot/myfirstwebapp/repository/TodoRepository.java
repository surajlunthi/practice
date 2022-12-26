package com.in28minutes.springboot.myfirstwebapp.repository;
import com.in28minutes.springboot.myfirstwebapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo,Long> {

}
