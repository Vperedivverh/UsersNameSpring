package com.example.usersnamespring.controller;

import com.example.usersnamespring.model.User;
import com.example.usersnamespring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("users", usersService.getAllUsers());
        return "users";
    }

    @GetMapping("/create")
    public String createUsersForm(User user) {
        return "create";
    }

    @PostMapping("/create")
    public String saveUser(User user) {
        usersService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        usersService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", usersService.getUserById(id));
        return "/update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") int id) {
        usersService.updateUser(id, user);
        return "redirect:/users";
    }
}