package com.cos.springbootthymleaf.service;

import com.cos.springbootthymleaf.model.user.User;
import com.cos.springbootthymleaf.model.user.UserRepository;
import com.cos.springbootthymleaf.web.dto.JoinReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void 회원가입(User user){
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRoles("ROLE_USER");
        userRepository.save(user);
    }

    @Transactional
    public User 회원수정(JoinReqDto dto, int id){
        User userEntity = userRepository.findById(id).orElseThrow(()->{
            throw new IllegalArgumentException("해당 유저를 찾을 수 없습니다.");
        });
        String encPassword = bCryptPasswordEncoder.encode(dto.getPassword());

        userEntity.setPassword(encPassword);
        userEntity.setEmail(dto.getEmail());
        userEntity.setNickname(dto.getNickname());
        return userEntity;
    }

}
