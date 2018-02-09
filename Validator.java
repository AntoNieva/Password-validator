package com.example.acme.csci3130_demo;

public class Validator {
    private final String[] passwordStrong={"very weak","weak","medium","strong","very strong"};

    private String validateResultStr;
    public String getValidateResultStr() {
        return validateResultStr;
    }

    public void setValidateResultStr(String validateResultStr) {
        this.validateResultStr = validateResultStr;
    }




    public String validatePassword(String passwordStr) {

        if (passwordStr != null) {
            if (passwordStr.trim().equalsIgnoreCase("password")) {
                setValidateResultStr("The password cannot be password");
            } else if (passwordStr.trim().length() < 8) {
                setValidateResultStr("The password lenght cannot be at least 8 characters long");
            }
           
            return getValidateResultStr();
        }

        return getValidateResultStr();
    }

}
