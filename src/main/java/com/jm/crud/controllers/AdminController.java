package com.jm.crud.controllers;

import com.jm.crud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/admin")
    public String userList(Model model){
        model.addAttribute("allUsers", userServiceImpl.allUsers());
        return "admin";
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userServiceImpl.deleteUser(id);
        return "redirect:/admin";
    }

}
