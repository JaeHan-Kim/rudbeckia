package com.rudbeckia.auth.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "admin_name", length = 20, unique = true, nullable = false)
	private String username;
	
	@Column(length = 400, nullable = false)
	private String password;
	
	@Column(nullable = false)
	private int userType;
	
	@Column(nullable = false)
	private LocalDateTime date;
}
