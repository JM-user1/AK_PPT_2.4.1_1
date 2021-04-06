package com.jm.crud.controllers;

import com.jm.crud.entity.User;
import com.jm.crud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

    @GetMapping("/edit/{id}")
    public String editUser( ModelMap modelMap, @PathVariable("id") Long id){
        modelMap.addAttribute("user",userServiceImpl.getById(id));
        return "/editUser";
    }

    @PatchMapping("/edit/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id")Long id){
        userServiceImpl.editUser(id, user);
        return "redirect:/";
    }

}
