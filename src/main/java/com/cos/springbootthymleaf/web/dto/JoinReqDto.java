package com.cos.springbootthymleaf.web.dto;

import com.cos.springbootthymleaf.model.user.User;
import lombok.Data;

@Data
public class JoinReqDto {
    private String username;
    private String password;
    private String email;
    private String nickname;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .nickname(nickname)
                .build();
    }

}
