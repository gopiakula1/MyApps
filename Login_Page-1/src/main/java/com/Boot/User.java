package com.Boot;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user123")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(length = 50)
    private String email;
    @Column(length = 50)
    private String password;
    @Column(name = "password_expiration_time")
    private LocalDateTime passwordExpirationTime;

    public LocalDateTime getPasswordExpirationTime() {
		return passwordExpirationTime;
	}
	public void setPasswordExpirationTime(LocalDateTime passwordExpirationTime) {
		this.passwordExpirationTime = passwordExpirationTime;
	}
	@Column(length = 50)
    private String resetTokens;
	public String getResetTokens() {
		return resetTokens;
	}
	public void setResetTokens(String resetTokens) {
		this.resetTokens = resetTokens;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setResetTokens(Object resetTokens2) {
		
	}
	
	

}
