package com.rudbeckia.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudbeckia.system.entity.CodeMst;
import com.rudbeckia.system.repository.coustom.CodeMstRepositoryCustom;


public interface CodeMstRepository extends JpaRepository<CodeMst, Long>, CodeMstRepositoryCustom {

}
