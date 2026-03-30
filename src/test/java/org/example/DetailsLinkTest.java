package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class DetailsLinkTest {

    @Test
    void testDetailsLink() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        try {
            driver.get("https://www.mts.by");

            WebElement cookieButton = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
            cookieButton.click();

            WebElement link = driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']"));
            assertTrue(link.isDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");
            System.out.println("Ссылка 'Подробнее о сервисе' найдена и отображается");

            String href = link.getAttribute("href");
            System.out.println("Адрес ссылки " + href);

            assertNotNull(href, "Атрибут href отсутствует");
            assertFalse(href.isEmpty(), "Атрибут href пустой");
            assertTrue(href.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                    "Ссылка ведёт не на ту страницу");

            link.click();
            assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl(),
                    "Переход на неправильный URL");
            System.out.println("Клик по ссылке выполнен, открыта нужная страница");

            WebElement pageTitle = driver.findElement(By.xpath("//h3[normalize-space()='Оплата банковской картой']"));
            assertTrue(pageTitle.isDisplayed(), "Блок 'Оплата банковской картой' не отображается");
            System.out.println("Блок 'Оплата банковской картой' отображается");

        } finally {
            driver.quit();
        }
    }
}
