package com.rudbeckia.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rudbeckia.auth.dto.AdminInfo;
import com.rudbeckia.auth.entity.Admin;
import com.rudbeckia.auth.repository.AdminRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService implements UserDetailsService {

    private final AdminRepository adminRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Admin admin = adminRepository.findByUsername(username);
        
        if (admin == null) {
            throw new UsernameNotFoundException("User Id not found");
        }
        return makeLoginUser(admin);
    }

    public AdminInfo makeLoginUser(Admin admin) {
        AdminInfo loginUser = new AdminInfo();
        
        List<GrantedAuthority> authorityList = new ArrayList<>();
        
        switch (admin.getUserType()) {
        case 0:
            authorityList.add(new SimpleGrantedAuthority("ADMIN"));
            break;
        case 1:
            authorityList.add(new SimpleGrantedAuthority("USER"));
            break;
        }
        
        loginUser.setUsername(admin.getUsername());
        loginUser.setPassword(admin.getPassword());
        loginUser.setAuthorities(authorityList);
        
        return loginUser;
    }
}
