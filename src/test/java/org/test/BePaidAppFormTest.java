package org.test;

import org.steps.CookieAgreementFormSteps;
import org.steps.PaySectionFormSteps;
import org.steps.BePaidAppFormSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;

@Epic("mts.by")
@Feature("Оплата: Услуги связи")
public class BePaidAppFormTest extends BaseTest {

    @Test
    @DisplayName("Проверка формы оплаты")
    @Description("Заполнение формы 'Услуги связи', переход к оплате, проверка формы оплаты")
    public void testBePaidFormAllChecks() {
        CookieAgreementFormSteps cookieSteps = new CookieAgreementFormSteps(driver);
        cookieSteps.closeCookieAgreement();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='connection-phone']")));

        PaySectionFormSteps paySteps = new PaySectionFormSteps(driver);
        paySteps.fillConnectionPayForm("297777777", "10", "test@mail.ru");
        BePaidAppFormSteps bePaidSteps = paySteps.proceedConnectionPayForm();

        bePaidSteps.switchToIframe();

        byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Форма оплаты заполнена", "image/png", new ByteArrayInputStream(screenshot1), "png");

        bePaidSteps.verifySum("10.00 BYN");
        bePaidSteps.verifySumOnButton("10.00 BYN");
        bePaidSteps.verifyPhoneNumber("375297777777");
        bePaidSteps.verifyAllCardPlaceholders();
        bePaidSteps.verifyAllPaymentIcons();

        byte[] screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Все поля проверены", "image/png", new ByteArrayInputStream(screenshot2), "png");
    }
}