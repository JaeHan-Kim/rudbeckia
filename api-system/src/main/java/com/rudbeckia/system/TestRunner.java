package com.rudbeckia.system;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.rudbeckia.system.dto.CodeMstDto;
import com.rudbeckia.system.service.CodeMstService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestRunner implements ApplicationRunner {

    @Autowired
    private CodeMstService codeMstService;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        CodeMstDto co = CodeMstDto.builder()
                        .codeMst("TEST")
                        .name("test")
                        .explain("test")
                        .useYn(true)
                        .regSeq(0L)
                        .modSeq(0L)
                        .regIp("127.0.0.1")
                        .modIp("127.0.0.1")
                        .regDt(LocalDateTime.now())
                        .modDt(LocalDateTime.now())
                        .build();
        
        log.info("! {}", co);
        this.codeMstService.createCodeMst(co);
    }

}