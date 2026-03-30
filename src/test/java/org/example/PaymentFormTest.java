package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

class PaymentFormTest {

    @Test
    void testPaymentForm() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {

            driver.get("https://www.mts.by");

            WebElement cookieButton = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
            cookieButton.click();

            WebElement phoneField = driver.findElement(By.xpath("//input[@id='connection-phone']"));
            phoneField.click();
            phoneField.sendKeys("297777777");

            WebElement sumField = driver.findElement(By.xpath("//input[@id='connection-sum']"));
            sumField.click();
            sumField.sendKeys("10");

            WebElement emailField = driver.findElement(By.xpath("//input[@id='connection-email']"));
            emailField.click();
            emailField.sendKeys("test@mail.ru");

            WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[text()='Продолжить']"));
            continueButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.className("payment-widget-iframe")
            ));
            driver.switchTo().frame(iframe);

            WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@id='cc-number']")
            ));
            System.out.println("Клик по кнопке 'Продолжить' выполнен");
            System.out.println("Форма оплаты отображается");
        }

        finally {
            driver.quit();
        }
    }
}
