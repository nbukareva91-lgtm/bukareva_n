package org.steps;

import org.page.BePaidAppForm;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashSet;
import java.util.Set;
import java.time.Duration;
import io.qameta.allure.Step;

public class BePaidAppFormSteps {

    private final BePaidAppForm bePaidAppForm;
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BePaidAppFormSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.bePaidAppForm = new BePaidAppForm(driver);
    }

    @Step("Переключиться на iframe формы оплаты")
    public void switchToIframe() {
        bePaidAppForm.switchToIframe();
    }

    @Step("Проверить сумму вверху страницы")
    public void verifySum(String expectedSum) {
        String actualSum = bePaidAppForm.getSumText();
        Assertions.assertEquals(expectedSum, actualSum,
                "Сумма на странице не соответствует ожидаемой");
        System.out.println("Сумма на странице: " + actualSum);
    }

    @Step("Проверить сумму на кнопке")
    public void verifySumOnButton(String expectedSum) {
        String actualSum = bePaidAppForm.getSumFromPayButton();
        Assertions.assertEquals(expectedSum, actualSum,
                "Сумма на кнопке не соответствует ожидаемой");
        System.out.println("Сумма на кнопке: " + actualSum);
    }

    @Step("Проверить номер телефона")
    public void verifyPhoneNumber(String expectedPhone) {
        String actualPhone = bePaidAppForm.getPhoneNumber();
        Assertions.assertEquals(expectedPhone, actualPhone,
                "Номер телефона не соответствует ожидаемому");
        System.out.println("Номер телефона: " + actualPhone);
    }

    public void verifyCardNumberPlaceholder(String expected) {
        String actual = bePaidAppForm.getCardNumberPlaceholder();
        Assertions.assertEquals(expected, actual,
                "Плейсхолдер 'Номер карты' не соответствует");
        System.out.println("Плейсхолдер 'Номер карты': " + actual);
    }

    public void verifyExpiryDatePlaceholder(String expected) {
        String actual = bePaidAppForm.getExpiryDatePlaceholder();
        Assertions.assertEquals(expected, actual,
                "Плейсхолдер 'Срок действия' не соответствует");
        System.out.println("Плейсхолдер 'Срок действия': " + actual);
    }

    public void verifyCvcPlaceholder(String expected) {
        String actual = bePaidAppForm.getCvcPlaceholder();
        Assertions.assertEquals(expected, actual,
                "Плейсхолдер 'CVC' не соответствует");
        System.out.println("Плейсхолдер 'CVC': " + actual);
    }

    public void verifyCardholderPlaceholder(String expected) {
        String actual = bePaidAppForm.getCardholderPlaceholder();
        Assertions.assertEquals(expected, actual,
                "Плейсхолдер 'Имя и фамилия' не соответствует");
        System.out.println("Плейсхолдер 'Имя и фамилия': " + actual);
    }

    @Step("Проверить плейсхолдеры полей карты: номер карты, срок действия, CVC, Имя и Фамилия")
    public void verifyAllCardPlaceholders() {
        verifyCardNumberPlaceholder("Номер карты");
        verifyExpiryDatePlaceholder("ММ / ГГ");
        verifyCvcPlaceholder("CVC");
        verifyCardholderPlaceholder("Имя и фамилия на карте");
    }

    public void verifyVisaIconDisplayed() {
        Assertions.assertTrue(bePaidAppForm.isVisaIconPresent(),
                "Иконка Visa не отображается");
        System.out.println("Иконка Visa отображается");
    }

    public void verifyMastercardIconDisplayed() {
        Assertions.assertTrue(bePaidAppForm.isMastercardIconPresent(),
                "Иконка MasterCard не отображается");
        System.out.println("Иконка MasterCard отображается");
    }

    public void verifyBelkartIconDisplayed() {
        Assertions.assertTrue(bePaidAppForm.isBelkartIconPresent(),
                "Иконка Белкарт не отображается");
        System.out.println("Иконка Белкарт отображается");
    }

    public void verifyDynamicIconDisplayed() {
        Set<String> displayedIcons = new HashSet<>();
        wait.until(driver -> {
            if (bePaidAppForm.isMirIconPresent()) displayedIcons.add("МИР");
            if (bePaidAppForm.isMaestroIconPresent()) displayedIcons.add("Maestro");
            return displayedIcons.size() == 2;
        });
        System.out.println("Динамические иконки МИР и Maestro отображались");
    }

    @Step("Проверить все иконки платежных систем:Visa, MasterCard, Белкарт, МИР, Maestro")
    public void verifyAllPaymentIcons() {
       verifyVisaIconDisplayed();//
        verifyMastercardIconDisplayed();
        verifyBelkartIconDisplayed();
        verifyDynamicIconDisplayed();
    }
}

