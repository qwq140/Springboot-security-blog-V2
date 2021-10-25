package com.cos.springbootthymleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UserController {

    @GetMapping("/user/{id}")
    public String updateForm(@PathVariable int id, Model model){
        model.addAttribute("id",id);
        return "/user/updateForm";
    }
}
