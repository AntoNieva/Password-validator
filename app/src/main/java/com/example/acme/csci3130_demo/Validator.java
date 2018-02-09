package com.example.acme.csci3130_demo;

public class Validator {

    public static int GRADE_SCORE =0 ;
    private final String[] passwordStrong={"very weak","weak","medium","strong","very strong"};

    private String validateResultStr;
    public String getValidateResultStr() {
        return validateResultStr;
    }

    public void setValidateResultStr(String validateResultStr) {
        this.validateResultStr = validateResultStr;
    }




    public String validatePassword(String passwordStr) {

        String regexZ = "\\d*";
        String regexS = "[a-zA-Z]+";
        String regexT = "\\W+$";
        String regexZT = "\\D*";
        String regexST = "[\\d\\W]*";
        String regexZS = "\\w*";
        String regexZST = "[\\w\\W]*";

        if (passwordStr != null) {
            if (passwordStr.trim().equalsIgnoreCase("password")) {
                setValidateResultStr("The password cannot be password");
            } else if (passwordStr.trim().length() < 8) {
                setValidateResultStr("The password lenght cannot be at least 8 characters long");
            }else if (passwordStr.matches(regexZ)) {
                GRADE_SCORE = 20;
                return passwordStrong[0];
            }else
            if (passwordStr.matches(regexS)) {
                GRADE_SCORE = 20;
                return passwordStrong[0];
            }else
            if (passwordStr.matches(regexT)) {
                GRADE_SCORE = 50;
                return passwordStrong[1];
            }else if (passwordStr.matches(regexZS )&& passwordStr.length()<12){
                GRADE_SCORE = 50;
                return passwordStrong[1];
            }else
            if (passwordStr.matches(regexZT)) {
                GRADE_SCORE = 80;
                return passwordStrong[3];
            }else
            if (passwordStr.matches(regexST)) {
                GRADE_SCORE = 60;
                return passwordStrong[2];
            }else
            if (passwordStr.matches(regexZS) && passwordStr.length()>=12) {
                GRADE_SCORE = 60;
                return passwordStrong[2];
            }else
            if (passwordStr.matches(regexZST)) {
                GRADE_SCORE = 90;
                return passwordStrong[4];
            }
            return getValidateResultStr();
        }

        return getValidateResultStr();
    }

}
