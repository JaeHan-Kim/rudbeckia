package com.rudbeckia.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudbeckia.auth.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByUsername(String name);
}