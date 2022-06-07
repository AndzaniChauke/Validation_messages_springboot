package com.example.messages.controller;

import com.example.messages.model.AppUser;
import com.example.messages.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/add")
    public String showAddUserForm(Model model){

        model.addAttribute("appUser",new AppUser());
        return "addUser";

    }

    @PostMapping("/add")
    public String addUser( @ModelAttribute("appUser") @Valid AppUser appUser,final BindingResult result,final Model model) {
        if (result.hasErrors()) {
            return "addUser";
        }
        repository.save(appUser);

        return "index";
    }


}
