package com.cos.springbootthymleaf.service;

import com.cos.springbootthymleaf.model.post.Post;
import com.cos.springbootthymleaf.model.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post 글쓰기(Post post){
        return postRepository.save(post);
    }

}
