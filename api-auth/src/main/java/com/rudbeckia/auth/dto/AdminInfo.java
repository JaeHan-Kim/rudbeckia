package com.rudbeckia.auth.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 클래스명: <code>AdminInfo</code><br/><br/>
 *
 * 설명을 기입하세요
 *
 * @since 2020. 10. 8.
 * @author JaeHan-Kim
 *
 */
@Getter @Setter
public class AdminInfo implements UserDetails, Serializable {

    private static final long serialVersionUID = 716930229126677485L;

    private String username;
    
    private String password;
    
    private List<GrantedAuthority> authorities;

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
