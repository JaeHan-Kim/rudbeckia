package com.rudbeckia.system.repository.coustom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;

import static com.rudbeckia.system.entity.QCodeMst.codeMst1;
import com.rudbeckia.system.dto.CodeMstDto;
import com.rudbeckia.system.entity.CodeMst;
import com.rudbeckia.system.repository.BaseRepository;
import com.rudbeckia.system.repository.coustom.CodeMstRepositoryCustom;

public class CodeMstRepositoryImpl extends BaseRepository implements CodeMstRepositoryCustom {

    public CodeMstRepositoryImpl() {
        super(CodeMst.class);
    }

    @Autowired
    private JPAQueryFactory queryFactory;
    

    @Override
    public List<CodeMstDto> findbyCodeMsts() {
        Expression<?>[] expr = super.getAllExpression(codeMst1);
        
        return queryFactory
                .select(Projections.bean(CodeMstDto.class, expr))
                .from(codeMst1)
                .fetch();
    }
}
