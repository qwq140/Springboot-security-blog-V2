package com.cos.springbootthymleaf.web.dto;

import com.cos.springbootthymleaf.model.post.Post;
import com.cos.springbootthymleaf.model.reply.Reply;
import com.cos.springbootthymleaf.model.user.User;
import lombok.Data;

@Data
public class ReplySaveReqDto {

    private String content;
    private int postId;

    public Reply toEntity(){
        return Reply.builder()
                .content(content)
                .build();
    }

}
