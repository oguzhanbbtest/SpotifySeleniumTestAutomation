package com.spotify.pages;

import com.spotify.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class GuestPage extends Methods {
    private final Logger logger = LogManager.getLogger(GuestPage.class);
    By singInElm = By.xpath("//button[@data-testid='login-button']");
    By oturumAc = By.xpath("//span[text()='Oturum aç']");
    By popUp = By.xpath("//button[@class=\"onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon\"]");
    public void isGuestPage(){
        Assertions.assertTrue(isElementVisible(oturumAc,2),"you are not in guestpage");
        logger.info("[TEST PASSED]");
    }
    public void clickLoginButton(){
        clickElement(singInElm);
        isGuestPage();
        logger.info("[TEST PASSED]");
    }

    public void closePopUp(){
        clickElement(popUp);
    }


}
