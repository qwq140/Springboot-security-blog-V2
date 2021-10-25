package com.cos.springbootthymleaf.web.api;

import com.cos.springbootthymleaf.config.auth.PrincipalDetails;
import com.cos.springbootthymleaf.model.reply.Reply;
import com.cos.springbootthymleaf.service.PostService;
import com.cos.springbootthymleaf.service.ReplyService;
import com.cos.springbootthymleaf.web.dto.CMRespDto;
import com.cos.springbootthymleaf.web.dto.PostSaveReqDto;
import com.cos.springbootthymleaf.web.dto.ReplySaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReplyApiController {

    private final ReplyService replyService;
    private final PostService postService;

    @PostMapping("/reply")
    public CMRespDto<?> save(@RequestBody ReplySaveReqDto replySaveReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails){
        Reply reply = replySaveReqDto.toEntity();
        reply.setPost(postService.글상세보기(replySaveReqDto.getPostId()));
        reply.setUser(principalDetails.getUser());
        return new CMRespDto<>(1,"댓글작성 성공", replyService.댓글작성(reply));
    }

    @DeleteMapping("/reply/{id}")
    public CMRespDto<?> deleteById(@PathVariable int id){
        replyService.댓글삭제(id);
        return new CMRespDto<>(1,"댓글삭제 성공",null);
    }

}
