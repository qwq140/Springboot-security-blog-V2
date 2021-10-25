package com.cos.springbootthymleaf.web.api;

import com.cos.springbootthymleaf.config.auth.PrincipalDetails;
import com.cos.springbootthymleaf.model.post.Post;
import com.cos.springbootthymleaf.service.PostService;
import com.cos.springbootthymleaf.web.dto.CMRespDto;
import com.cos.springbootthymleaf.web.dto.PostSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping("/post")
    public CMRespDto<?> save(@RequestBody PostSaveReqDto postSaveReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails){
        return new CMRespDto<>(1,"글쓰기 성공", postService.글쓰기(postSaveReqDto.toEntity(principalDetails.getUser())));
    }

    @PutMapping("/post/{id}")
    public CMRespDto<?> update(@RequestBody PostSaveReqDto postSaveReqDto, @PathVariable int id){
        postService.글수정하기(postSaveReqDto,id);
        return new CMRespDto<>(1, "수정 성공", null);
    }

    @DeleteMapping("/post/{id}")
    public CMRespDto<?> delete(@PathVariable int id){
        postService.글삭제하기(id);
        return new CMRespDto<>(1,"삭제 성공",null);
    }

}
