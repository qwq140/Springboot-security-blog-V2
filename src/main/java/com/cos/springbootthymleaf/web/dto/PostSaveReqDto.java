package com.cos.springbootthymleaf.web.dto;

import com.cos.springbootthymleaf.model.post.Post;
import com.cos.springbootthymleaf.model.user.User;
import lombok.Data;

@Data
public class PostSaveReqDto {

    private String title;
    private String content;

    public Post toEntity(User user){
        return Post.builder()
                .title(title)
                .content(content)
                .user(user) // principal
                .build();
    }

}
