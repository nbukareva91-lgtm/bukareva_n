package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class PaymentLogosTest {

    @Test
    void testPaymentLogos() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        try {
            driver.get("https://www.mts.by");

            WebElement visa = driver.findElement(By.xpath("//img[@alt='Visa']"));
            assertTrue(visa.isDisplayed(), "Visa не отображается");
            System.out.println("Visa найден");

            WebElement verifiedByVisa = driver.findElement(By.xpath("//img[@alt='Verified By Visa']"));
            assertTrue(verifiedByVisa.isDisplayed(), "Verified By Visa не отображается");
            System.out.println("Verified By Visa найден");

            WebElement mastercardSecure = driver.findElement(By.xpath("//img[@alt='MasterCard Secure Code']"));
            assertTrue(mastercardSecure.isDisplayed(), "MasterCard Secure Code не отображается");
            System.out.println("MasterCard Secure Code найден");

            WebElement mastercard = driver.findElement(By.xpath("//div[@class='pay__partners']//img[@alt='MasterCard']"));
            assertTrue(mastercard.isDisplayed(), "MasterCard не отображается");
            System.out.println("MasterCard найден");

            WebElement belkart = driver.findElement(By.xpath("//div[@class='pay__partners']//img[@alt='Белкарт']"));
            assertTrue(belkart.isDisplayed(), "Белкарт не отображается");
            System.out.println("Белкарт найден");

        } finally {
            driver.quit();
        }
    }
}
