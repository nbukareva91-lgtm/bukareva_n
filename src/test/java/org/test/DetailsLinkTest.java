package org.test;

import org.steps.CookieAgreementFormSteps;
import org.steps.DetailsLinkSteps;
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
@Feature("Подробнее о сервисе")
public class DetailsLinkTest extends BaseTest {

    @Test
    @DisplayName("Проверка ссылки 'Подробнее о сервисе'")
    @Description("Переход по ссылке 'Подробнее о сервисе и проверка страницы 'Оплата банковской картой'")
    public void testDetailsLink() {
        CookieAgreementFormSteps cookieSteps = new CookieAgreementFormSteps(driver);
        cookieSteps.closeCookieAgreement();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='connection-phone']")));

        DetailsLinkSteps detailsSteps = new DetailsLinkSteps(driver);

        detailsSteps.clickDetailsLink();

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Страница Порядок оплаты и безопасность интернет платежей", "image/png", new ByteArrayInputStream(screenshot), "png");

        detailsSteps.verifyPageTitleDisplayed();
        detailsSteps.verifyPageTitleText("Оплата банковской картой");
    }
}
