package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class OnlinePaymentTitleTest {

    @Test
    void testOnlinePaymentTitle() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        try {
            driver.get("https://www.mts.by");

            WebElement title = driver.findElement(By.xpath("//*[contains(text(), 'Онлайн пополнение')]"));

            String actualText = title.getText();

            assertTrue(actualText.contains("Онлайн пополнение"), "Текст не содержит 'Онлайн пополнение'");
            assertTrue(actualText.contains("без комиссии"), "Текст не содержит 'без комиссии'");

            System.out.println("Заголовок найден: " + actualText);

        } finally {
            driver.quit();
        }
    }
}
