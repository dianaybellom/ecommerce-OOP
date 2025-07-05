package com.arcadia.ecommerce;

public class SystemConfig {
    private static SystemConfig instance;
    private String dbConnectionString;
    private String uiTheme;
    private boolean enableLogging;

    private SystemConfig() {
        // Valores por defecto
        dbConnectionString = "jdbc:mysql://localhost:3306/ecommerce-db";
        uiTheme = "light";
        enableLogging = true;
    }

    public static synchronized SystemConfig getInstance() {
        if (instance == null) {
            instance = new SystemConfig();
        }
        return instance;
    }

    public String getDbConnectionString() { 
    	return dbConnectionString; 
    	}
    
    public void setDbConnectionString(String value) { 
    	dbConnectionString = value; 
    	}

    public String getUiTheme() { 
    	return uiTheme; 
    	}
    
    public void setUiTheme(String value) { 
    	uiTheme = value; 
    	}

    public boolean isLoggingEnabled() { 
    	return enableLogging; 
    	}
    
    public void setEnableLogging(boolean value) { 
    	enableLogging = value; 
    	}
}
