package com.rudbeckia.system.service;

import org.springframework.stereotype.Service;

import com.rudbeckia.system.dto.CodeMstDto;
import com.rudbeckia.system.entity.CodeMst;
import com.rudbeckia.system.repository.CodeMstRepository;

import lombok.RequiredArgsConstructor;

import static com.rudbeckia.system.utils.ObjectMapperUtils.map;
import static com.rudbeckia.system.utils.ObjectMapperUtils.mapList;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeMstService {

    private final CodeMstRepository codeMstRepository;

    public List<CodeMstDto> getCodeMsts() {
        return codeMstRepository.findbyCodeMsts();
    }

    public CodeMstDto createCodeMst(CodeMstDto data) {
        
        CodeMst entity = codeMstRepository.save(map(data, CodeMst.class));
        
        return map(entity, CodeMstDto.class);
    }
}
