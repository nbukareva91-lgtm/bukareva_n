package org.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DetailsLink {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By detailsLink = By.xpath("//a[text()='Подробнее о сервисе']");
    private final By pageTitle = By.xpath("//h3[normalize-space()='Оплата банковской картой']");

    public DetailsLink(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickDetailsLink() {
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(detailsLink));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
        System.out.println("Нажата ссылка 'Подробнее о сервисе'");
    }

      public boolean isPageTitleDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

     public String getPageTitleText() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return title.getText();
    }
}