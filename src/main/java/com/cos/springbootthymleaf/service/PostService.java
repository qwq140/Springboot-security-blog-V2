package com.cos.springbootthymleaf.service;

import com.cos.springbootthymleaf.model.post.Post;
import com.cos.springbootthymleaf.model.post.PostRepository;
import com.cos.springbootthymleaf.web.dto.PostSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post 글쓰기(Post post){
        return postRepository.save(post);
    }

    public Page<Post> 글목록보기(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    public Post 글상세보기(int id){
        return postRepository.findById(id).orElseThrow(()->{
            throw new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
        });
    }

    @Transactional
    public void 글수정하기(PostSaveReqDto dto, int id){
        Post postEntity = postRepository.findById(id).orElseThrow(()->{
            throw new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
        });
        postEntity.setTitle(dto.getTitle());
        postEntity.setContent(dto.getContent());
    }

    @Transactional
    public void 글삭제하기(int id){
        postRepository.deleteById(id);
    }

}
