package utils;

public class EnvironmentConfig {

    public static final String appUrl;
    public static final String loginAdmin;
    public static final String passwordAdmin;

    static {
        appUrl = "https://misp-qa.by2.epm-chrt.projects.epam.com/";
        loginAdmin = "auto_misp";
        passwordAdmin = "password";
    }
}
