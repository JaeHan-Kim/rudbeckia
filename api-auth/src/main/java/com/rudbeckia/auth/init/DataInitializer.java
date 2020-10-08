package com.rudbeckia.auth.init;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.rudbeckia.auth.entity.Admin;
import com.rudbeckia.auth.repository.AdminRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * 클래스명: <code>DataInitializer</code><br/><br/>
 *
 * test용 admin data init
 *
 * @since 2020. 10. 8.
 * @author JaeHan-Kim
 *
 */
@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final AdminRepository adminRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Admin test = new Admin();

        PasswordEncoder passwordEncoder;
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        test.setUsername("test");
        test.setPassword(passwordEncoder.encode("test"));
        test.setUserType(0);
        test.setDate(LocalDateTime.now());
        adminRepository.save(test);
    }

}
