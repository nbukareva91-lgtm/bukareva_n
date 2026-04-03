package org.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BePaidAppForm {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By iframeLocator = By.className("payment-widget-iframe");
    private final By sumAmount = By.xpath("//span[contains(text(), 'BYN')]");
    private final By phoneNumber = By.xpath("//span[contains(text(), 'Номер:')]");
    private final By cardNumberField = By.xpath("//label[contains(text(), 'Номер карты')]");
    private final By expiryDateField = By.xpath("//input[@placeholder='ММ / ГГ']");
    private final By cvcField = By.xpath("//label[text()='CVC']");
    private final By cardholderField = By.xpath("//label[text()='Имя и фамилия на карте']");
    private final By payButton = By.xpath("//button//span[contains(text(), 'Оплатить')]");
    private final By visaIcon = By.xpath("//img[contains(@src, 'visa-system.svg')]");
    private final By mastercardIcon = By.xpath("//img[contains(@src, 'mastercard-system.svg')]");
    private final By belkartIcon = By.xpath("//img[contains(@src, 'belkart-system.svg')]");
    private final By mirIcon = By.xpath("//img[contains(@src, 'mir-system-ru.svg')]");
    private final By maestroIcon = By.xpath("//img[contains(@src, 'maestro-system.svg')]");

    public BePaidAppForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void switchToIframe() {
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
        driver.switchTo().frame(iframe);
        System.out.println("Переключились на форму оплаты");
    }

    public String getSumText() {
        WebElement sum = wait.until(ExpectedConditions.visibilityOfElementLocated(sumAmount));
        return sum.getText();
    }

    public String getPhoneNumber() {
        WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumber));
        return phone.getText().replaceAll(".*Номер:", "").trim();
    }

    public String getSumFromPayButton() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(payButton));
        return button.getText().replaceAll("Оплатить", "").trim();
    }

    public String getCardNumberPlaceholder() {
        try {
            WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberField));
            return label.getText();
        } catch (Exception e) {
            System.out.println("Ошибка Номер карты: " + e.getMessage());
            return "";
        }
    }

    public String getExpiryDatePlaceholder() {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(expiryDateField));
        return field.getAttribute("placeholder");
    }

    public String getCvcPlaceholder() {
        try {
            WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(cvcField));
            return label.getText();
        } catch (Exception e) {
            System.out.println("Ошибка CVC: " + e.getMessage());
            return "";
        }
    }

    public String getCardholderPlaceholder() {
        try {
            WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(cardholderField));
            return label.getText();
        } catch (Exception e) {
            System.out.println("Ошибка Имя: " + e.getMessage());
            return "";
        }
    }

    public boolean isVisaIconPresent() {
        return !driver.findElements(visaIcon).isEmpty();
    }

    public boolean isMastercardIconPresent() {
        return !driver.findElements(mastercardIcon).isEmpty();
    }

    public boolean isBelkartIconPresent() {
        return !driver.findElements(belkartIcon).isEmpty();
    }

    public boolean isMirIconPresent() {
        return !driver.findElements(mirIcon).isEmpty();
    }

    public boolean isMaestroIconPresent() {
        return !driver.findElements(maestroIcon).isEmpty();
    }
}