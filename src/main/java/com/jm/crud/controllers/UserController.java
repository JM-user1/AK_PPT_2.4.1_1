package com.jm.crud.controllers;


import com.jm.crud.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.jm.crud.entity.User;


@Controller
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }


  @GetMapping("/")
  public String start(ModelMap modelMap){
    modelMap.addAttribute("users", userService.allUser());
    modelMap.addAttribute("user", new User());
    return "users";
  }

  @PostMapping()
  public String addUser(@ModelAttribute("user") User user){
    userService.add(user);
    return "redirect:/";
  }

  @GetMapping("/edit/{id}")
  public String editUser(@NotNull ModelMap modelMap, @PathVariable("id") Long id){
    modelMap.addAttribute("user",userService.getById(id));
    return "/editUser";
  }

  @PatchMapping("/edit/{id}")
  public String editUser(@ModelAttribute("user") User user, @PathVariable("id")Long id){
    userService.edit(id, user);
    return "redirect:/";
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable("id") Long id){
    userService.delete(id);
    return "redirect:/";
  }


}
