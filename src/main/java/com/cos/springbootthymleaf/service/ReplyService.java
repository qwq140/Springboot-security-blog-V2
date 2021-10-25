package com.cos.springbootthymleaf.service;

import com.cos.springbootthymleaf.model.reply.Reply;
import com.cos.springbootthymleaf.model.reply.ReplyRepository;
import com.cos.springbootthymleaf.web.dto.PostSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ReplyService {

    private final ReplyRepository replyRepository;

    @Transactional
    public Reply 댓글작성(Reply reply){
        return replyRepository.save(reply);
    }

    @Transactional
    public void 댓글삭제(int id){
        replyRepository.deleteById(id);
    }


}
