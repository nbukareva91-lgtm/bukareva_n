package org.test;

import org.steps.CookieAgreementFormSteps;
import org.steps.PaySectionFormSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;

@Epic("mts.by")
@Feature("Онлайн пополнение без комиссии")
public class PaySectionFormTest extends BaseTest {

    private PaySectionFormSteps paySteps;

    @BeforeEach
    public void init() {
        driver.switchTo().defaultContent();

        CookieAgreementFormSteps cookieSteps = new CookieAgreementFormSteps(driver);
        cookieSteps.closeCookieAgreement();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='connection-phone']")));

        paySteps = new PaySectionFormSteps(driver);
    }

    @Test
    @DisplayName("Проверка блока 'Онлайн пополнение без комиссии'")
    @Description("Проверка выпадающего меню и надписей в незаполненных полях каждого варианта оплаты услуг")
    public void testServicePlaceholders() {

        Assertions.assertEquals("Номер телефона", paySteps.getFieldPlaceholder("pay-connection", "phone"));
        Assertions.assertEquals("Сумма", paySteps.getFieldPlaceholder("pay-connection", "sum"));
        Assertions.assertEquals("E-mail для отправки чека", paySteps.getFieldPlaceholder("pay-connection", "email"));

        paySteps.choosePayOption("Домашний интернет");
        Assertions.assertEquals("Номер абонента", paySteps.getFieldPlaceholder("pay-internet", "phone"));
        Assertions.assertEquals("Сумма", paySteps.getFieldPlaceholder("pay-internet", "sum"));
        Assertions.assertEquals("E-mail для отправки чека", paySteps.getFieldPlaceholder("pay-internet", "email"));

        paySteps.choosePayOption("Рассрочка");
        Assertions.assertEquals("Номер счета на 44", paySteps.getFieldPlaceholder("pay-instalment", "score"));
        Assertions.assertEquals("Сумма", paySteps.getFieldPlaceholder("pay-instalment", "sum"));
        Assertions.assertEquals("E-mail для отправки чека", paySteps.getFieldPlaceholder("pay-instalment", "email"));

        paySteps.choosePayOption("Задолженность");
        Assertions.assertEquals("Номер счета на 2073", paySteps.getFieldPlaceholder("pay-arrears", "score"));
        Assertions.assertEquals("Сумма", paySteps.getFieldPlaceholder("pay-arrears", "sum"));
        Assertions.assertEquals("E-mail для отправки чека", paySteps.getFieldPlaceholder("pay-arrears", "email"));

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Форма 'Услуги связи' открыта", "image/png", new ByteArrayInputStream(screenshot), "png");

        System.out.println("Все плейсхолдеры проверены");
    }
}