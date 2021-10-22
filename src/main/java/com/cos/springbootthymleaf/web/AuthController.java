package com.cos.springbootthymleaf.web;
import com.cos.springbootthymleaf.service.UserService;
import com.cos.springbootthymleaf.web.dto.CMRespDto;
import com.cos.springbootthymleaf.web.dto.JoinReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@Controller
public class AuthController {

    private final UserService userService;

    @GetMapping("/loginForm")
    public String loginForm(){
        return "auth/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "auth/joinForm";
    }

    @PostMapping("/join")
    public String join(JoinReqDto joinReqDto){
        userService.회원가입(joinReqDto.toEntity());
        return "redirect:/loginForm"; // viewName을 리턴하는 경우는 해당 view를 보여주는 것이고 redirect는 해당 주소로 URL 요청을 다시 하는 것이다.
    }

}
