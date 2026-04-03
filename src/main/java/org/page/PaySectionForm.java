package org.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PaySectionForm {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By connectionServiceTab = By.xpath("//button[@class='select__header']");
    private final By homeInternetOption = By.xpath("//p[text()='Домашний интернет']");
    private final By installmentOption = By.xpath("//p[text()='Рассрочка']");
    private final By debtOption = By.xpath("//p[text()='Задолженность']");

    //локаторы услуги связи
    private final By connectionPhoneField = By.xpath("//input[@id='connection-phone']");
    private final By connectionSumField = By.xpath("//input[@id='connection-sum']");
    private final By connectionEmailField = By.xpath("//input[@id='connection-email']");
    private final By connectionContinueButton = By.xpath("//form[@id='pay-connection']//button[text()='Продолжить']");

    //локаторы дом интернет
    private final By internetPhoneField = By.xpath("//input[@id='internet-phone']");
    private final By internetSumField = By.xpath("//input[@id='internet-sum']");
    private final By internetEmailField = By.xpath("//input[@id='internet-email']");

    //локаторы рассрочка
    private final By instalmentScoreField = By.xpath("//input[@placeholder='Номер счета на 44']");
    private final By instalmentSumField = By.xpath("//input[@id='instalment-sum']");
    private final By instalmentEmailField = By.xpath("//input[@id='instalment-email']");

    //локаторы задолженность
    private final By arrearsScoreField = By.xpath("//input[@id='score-arrears']");
    private final By arrearsSumField = By.xpath("//form[@id='pay-arrears']//input[@id='arrears-sum']");
    private final By arrearsEmailField = By.xpath("//input[@id='arrears-email']");

    public PaySectionForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openDropdownMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(connectionServiceTab)).click();
    }

    public void selectServiceFromMenu(String serviceName) {
        By optionLocator;
        switch (serviceName) {
            case "Услуги связи":
                optionLocator = connectionServiceTab;
                break;
            case "Домашний интернет":
                optionLocator = homeInternetOption;
                break;
            case "Рассрочка":
                optionLocator = installmentOption;
                break;
            case "Задолженность":
                optionLocator = debtOption;
                break;
            default:
                System.out.println("Неизвестная услуга: " + serviceName);
                return;
        }
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void enterConnectionPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(connectionPhoneField)).sendKeys(phone);
        System.out.println("Введен номер телефона: " + phone);
    }

    public void enterConnectionSum(String sum) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(connectionSumField)).sendKeys(sum);
        System.out.println("Введена сумма: " + sum);
    }

    public void enterConnectionEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(connectionEmailField)).sendKeys(email);
        System.out.println("Введен email: " + email);
    }

    public void clickConnectionContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(connectionContinueButton)).click();
    }

    public String getFieldPlaceholder(String formId, String fieldType) {
        By fieldLocator;
        switch (formId) {
            case "pay-connection":
                switch (fieldType) {
                    case "phone":
                        fieldLocator = connectionPhoneField;
                        break;
                    case "sum":
                        fieldLocator = connectionSumField;
                        break;
                    case "email":
                        fieldLocator = connectionEmailField;
                        break;
                    default:
                        return "";
                }
                break;
            case "pay-internet":
                switch (fieldType) {
                    case "phone":
                        fieldLocator = internetPhoneField;
                        break;
                    case "sum":
                        fieldLocator = internetSumField;
                        break;
                    case "email":
                        fieldLocator = internetEmailField;
                        break;
                    default:
                        return "";
                }
                break;
            case "pay-instalment":
                switch (fieldType) {
                    case "score":
                        fieldLocator = instalmentScoreField;
                        break;
                    case "sum":
                        fieldLocator = instalmentSumField;
                        break;
                    case "email":
                        fieldLocator = instalmentEmailField;
                        break;
                    default:
                        return "";
                }
                break;
            case "pay-arrears":
                switch (fieldType) {
                    case "score":
                        fieldLocator = arrearsScoreField;
                        break;
                    case "sum":
                        fieldLocator = arrearsSumField;
                        break;
                    case "email":
                        fieldLocator = arrearsEmailField;
                        break;
                    default:
                        return "";
                }
                break;
            default:
                return "";
        }
        return driver.findElement(fieldLocator).getAttribute("placeholder");
    }
}
