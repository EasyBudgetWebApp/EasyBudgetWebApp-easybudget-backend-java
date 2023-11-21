package com.example.sweater.controller;

import com.example.sweater.domain.User;
import com.example.sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/registration1")
    public String showForm(User user) {
        return "registration1";
    }

    @PostMapping("/registration1")
    public String submitForm(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration1";
        }

        // Procesați obiectul User și efectuați acțiunile necesare aici
        model.addAttribute("mesaj", "Validare reușită!"); // Mesajul de succes
        return "success"; // Redirecționare după succes
    }
}
