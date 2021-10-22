package com.cos.springbootthymleaf.web.api;

import com.cos.springbootthymleaf.config.auth.PrincipalDetails;
import com.cos.springbootthymleaf.model.post.Post;
import com.cos.springbootthymleaf.service.PostService;
import com.cos.springbootthymleaf.web.dto.CMRespDto;
import com.cos.springbootthymleaf.web.dto.PostSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping("/post")
    public CMRespDto<?> save(@RequestBody PostSaveReqDto postSaveReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails){
        return new CMRespDto<>(1,"글쓰기 성공", postService.글쓰기(postSaveReqDto.toEntity(principalDetails.getUser())));
    }

}
