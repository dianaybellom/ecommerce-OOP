package com.arcadia.ecommerce;

import java.time.LocalDateTime;

public class Session {
    private String id;
    private String userId;
    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;

    public Session(String id, String userId, LocalDateTime loginTime) {
        this.id = id;
        this.userId = userId;
        this.loginTime = loginTime;
    }

    public void endSession() {
        this.logoutTime = LocalDateTime.now();
    }
}
