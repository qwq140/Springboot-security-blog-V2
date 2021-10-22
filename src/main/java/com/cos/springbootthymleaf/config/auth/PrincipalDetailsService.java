package com.cos.springbootthymleaf.config.auth;

import com.cos.springbootthymleaf.model.user.User;
import com.cos.springbootthymleaf.model.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


// UserDetailsSerivce는 유저의 정보를 가지고 오는 인터페이스
@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // 유저의 정보를 불러와서 UserDetails로 리턴을 해주는 메서드
    // /login이 호출 되면 자동으로 실행되어 username이 DB에 있는지 확인한다.
   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username);

        if(principal == null){
            return null;
        }else {
            return new PrincipalDetails(principal);
        }
    }
}
