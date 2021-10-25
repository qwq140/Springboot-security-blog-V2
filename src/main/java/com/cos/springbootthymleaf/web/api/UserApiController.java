package com.cos.springbootthymleaf.web.api;

import com.cos.springbootthymleaf.config.auth.PrincipalDetails;
import com.cos.springbootthymleaf.model.user.User;
import com.cos.springbootthymleaf.service.UserService;
import com.cos.springbootthymleaf.web.dto.CMRespDto;
import com.cos.springbootthymleaf.web.dto.JoinReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PutMapping("/user/{id}")
    public CMRespDto<?> update(@PathVariable int id, @RequestBody JoinReqDto joinReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails){
        User userEntity = userService.회원수정(joinReqDto, id);
        System.out.println(userEntity);
        principalDetails.setUser(userEntity);
        return new CMRespDto<>(1,"회원수정 성공", null);
    }


}
