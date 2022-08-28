package com.spotify.pages;

import com.spotify.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginPage extends Methods {
    private final Logger logger = LogManager.getLogger(LoginPage.class);

    private final String EMAIL = "oguzhanbbtest@gmail.com";
    private final String PASSWORD = "test123123";

    By loginEmail = By.xpath("//input[@id='login-username']");
    By loginPassword = By.xpath("//input[@id='login-password']");
    By loginButton = By.id("login-button");

    By loginElem = By.id("login-to-continue");

    public void isLoginPage(){
        Assertions.assertTrue(isElementVisible(loginElem,10),"you are not Login Page");
        logger.info("[TEST PASSED]");
    }

    public void loginSpotify(){
        isLoginPage();
        scrollElement(loginEmail);

        Assertions.assertTrue(isElementClickable(loginEmail,10));
        findElementWait(loginEmail).click();
        sendKeys(loginEmail, EMAIL);

        Assertions.assertTrue(isElementClickable(loginPassword,10));
        findElementWait(loginPassword).click();
        sendKeys(loginPassword,PASSWORD);
        clickLogin();
        logger.info("[TEST PASSED]");
    }

    public void clickLogin(){
        Assertions.assertTrue(isElementClickable(loginButton, 10));
        findElementWait(loginButton).click();
        logger.info("[TEST PASSED]");
    }

}
