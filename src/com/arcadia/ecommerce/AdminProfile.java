package com.arcadia.ecommerce;

public class AdminProfile extends User {
    private AdminType adminType;

    public AdminProfile(
        String id,
        String email,
        String password,
        String phone,
        Role role,
        String gender,
        AdminType adminType
    ) {
        super(id, email, password, phone, role, gender);
        this.adminType = adminType;
    }

    public boolean canManageProducts() {
        return adminType == AdminType.MANAGER || adminType == AdminType.BACKOFFICE;
    }

    public boolean canManageStock() {
        return adminType == AdminType.MANAGER || adminType == AdminType.BACKOFFICE;
    }

    public boolean canViewReports() {
        return adminType == AdminType.MANAGER;
    }

    public boolean canManageOrders() {
    	return adminType == AdminType.MANAGER || adminType == AdminType.BACKOFFICE;
    }

    public AdminType getAdminType() {
        return adminType;
    }

    public void setAdminType(AdminType adminType) {
        this.adminType = adminType;
    }
}
