package com.cos.springbootthymleaf.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PostController {

    @GetMapping("/")
    public String findAll(){
        return "post/list";
    }

    @GetMapping("/post/saveForm")
    public String saveForm(){
        return "/post/saveForm";
    }

}
