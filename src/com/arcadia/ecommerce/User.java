package com.arcadia.ecommerce;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class User {
    private String id;
    private String email;
    private String password;
    private String phone;
    private Role role;
    private String gender;

    public User(String id, String email, String password, String phone, Role role, String gender) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.gender = gender;
    }

    public Session login(String email, String password) {
        if (!this.email.equals(email) || !this.password.equals(password)) {
            throw new IllegalArgumentException("Credenciales inválidas");
        }
        String sessionId = UUID.randomUUID().toString();
        return new Session(sessionId, this.id, LocalDateTime.now());
    }

    public void logout() {
    	//TODO: Implementar
    }

    public String getId(){ 
    	return id;
    }
    
    public Role getRole(){
    	return role;
    }
    
    public String getEmail(){
    	return email;
    }
    
    public String getPhone(){
    	return phone;
    }

    public void setPhone(String newPhone){ 
    	this.phone = newPhone;
    }
    
    public void setPassword(String newPassword){
    	this.password = newPassword;
    }
}
