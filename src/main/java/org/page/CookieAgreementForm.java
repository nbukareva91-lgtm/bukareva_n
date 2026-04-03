package org.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CookieAgreementForm {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By acceptButton = By.xpath("//button[@id='cookie-agree']");

    public CookieAgreementForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void acceptCookies() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(acceptButton)).click();
        } catch (Exception e) {
        }
    }
}
