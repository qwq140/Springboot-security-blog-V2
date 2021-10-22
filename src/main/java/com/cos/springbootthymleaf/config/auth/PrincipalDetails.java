package com.cos.springbootthymleaf.config.auth;

import com.cos.springbootthymleaf.model.user.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class PrincipalDetails implements UserDetails {

    // 컴포지션 : 다른 객체의 인스턴스를 자신의 인스턴스 변수로 포함해서 메서드를 호출하는 기법
    private User user;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    // 계정의 권한 목록을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoleList().forEach(r->{
            authorities.add(()->r);
        });
        return authorities;
    }

    // 계정의 패스워드를 리턴
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // 계정의 교유한 값을 리턴 , username 리턴
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 계정의 만료 여부 리턴 (true : 만료 안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정의 잠김 여부 리턴 (true : 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 패스워드 만료 여부 리턴 (true : 만료 안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정의 활성화 여부 리턴 (true 활성화 됨)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
