package com.arcadia.ecommerce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CustomerProfile extends User {
    private LoyaltyLevel loyaltyLevel;
    private BigDecimal discountRate;
    private List<String> preferences;
    private LocalDateTime preferencesUpdatedAt;

    public CustomerProfile(
        String id,
        String email,
        String password,
        String phone,
        Role role,
        String gender,
        LoyaltyLevel loyaltyLevel,
        BigDecimal discountRate,
        List<String> preferences,
        LocalDateTime preferencesUpdatedAt
    ) {
        super(id, email, password, phone, role, gender);
        this.loyaltyLevel = loyaltyLevel;
        this.discountRate = discountRate;
        this.preferences = preferences;
        this.preferencesUpdatedAt = preferencesUpdatedAt;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
        this.preferencesUpdatedAt = LocalDateTime.now();
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setLoyaltyLevel(LoyaltyLevel newLevel) {
        this.loyaltyLevel = newLevel;
        switch (newLevel) {
            case STELLAR:
                this.discountRate = new BigDecimal("0.05");
                break;
            case MUSE_COLLECTOR:
                this.discountRate = new BigDecimal("0.10");
                break;
            default:
                this.discountRate = BigDecimal.ZERO;
        }
    }

    public LoyaltyLevel getLoyaltyLevel() {
        return loyaltyLevel;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }
}
