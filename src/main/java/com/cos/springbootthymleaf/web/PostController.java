package com.cos.springbootthymleaf.web;

import com.cos.springbootthymleaf.model.post.Post;
import com.cos.springbootthymleaf.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    @GetMapping("/post/saveForm")
    public String saveForm(){
        return "/post/saveForm";
    }

    @GetMapping("/")
    public String findAll(Model model, @PageableDefault(sort = "id",direction = Sort.Direction.DESC, size = 5) Pageable pageable){
        Page<Post> posts = postService.글목록보기(pageable);
        model.addAttribute("posts",posts);
        return "/post/list";
    }

    @GetMapping("/post/{id}")
    public String findById(@PathVariable int id, Model model){
        Post post = postService.글상세보기(id);
        model.addAttribute("post",post);
        return "/post/detail";
    }

    @GetMapping("/post/{id}/updateForm")
    public String updateForm(Model model, @PathVariable int id){
        Post post = postService.글상세보기(id);
        model.addAttribute("post", post);
        return "/post/updateForm";
    }

}
