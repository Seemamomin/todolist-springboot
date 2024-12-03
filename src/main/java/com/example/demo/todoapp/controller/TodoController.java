package com.example.demo.todoapp.controller;

import com.example.demo.todoapp.model.Todo;
import com.example.demo.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String getAllTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "index"; // Thymeleaf template name
    }

    @PostMapping("/add")
    public String addTodo(Todo todo) {
        todoService.saveTodo(todo);
        return "redirect:/";
    }
}
