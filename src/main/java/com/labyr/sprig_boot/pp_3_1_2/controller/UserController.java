package com.labyr.sprig_boot.pp_3_1_2.controller;

import com.labyr.sprig_boot.pp_3_1_2.model.User;
import com.labyr.sprig_boot.pp_3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }


    @PostMapping("/add")
    public String addSubmit(@ModelAttribute User user) {
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }


    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }


    @GetMapping("/edit")
    public String editPage(@RequestParam("id") Long id, Model model) {
        Object user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }


    @PostMapping("/edit")
    public String editSubmit(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
