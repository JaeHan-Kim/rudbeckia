package com.rudbeckia.auth.web.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rudbeckia.auth.dto.AdminInfo;
import com.rudbeckia.auth.entity.Admin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AuthController {

    /**
     * 
     * 설명을 기입하세요
     *
     * @since 2020. 10.' 8.
     * @author JaeHan-Kim
     *
     * @param admin
     * @return
     * @throws JsonProcessingException
     */
    @PostMapping("/login")
    public String login(AdminInfo admin) throws JsonProcessingException {
        log.info("admin Id {}", admin.getUsername());
        log.info("pwd {}", admin.getPassword());

        
        HttpHeaders h = new HttpHeaders();
        h.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        h.setBasicAuth("auth_id", "auth_secret");
        
        StringBuilder httpEntity =  new StringBuilder();
        
        httpEntity.append("grant_type=password");
        httpEntity.append("&username=" + admin.getUsername());
        httpEntity.append("&password=" + admin.getPassword());
        
        log.info("httpEntity {}", httpEntity.toString());
        HttpEntity<String> request = new HttpEntity<String>(httpEntity.toString(), h);
        log.info("{}", request.getBody());
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject("http://localhost:8095/oauth/token", request, String.class);
        
        return result;
    }
}
