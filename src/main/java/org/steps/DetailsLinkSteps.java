package org.steps;

import org.page.DetailsLink;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;
import io.qameta.allure.Step;

public class DetailsLinkSteps {

    private final DetailsLink detailsLink;

    public DetailsLinkSteps(WebDriver driver) {
        this.detailsLink = new DetailsLink(driver);
    }

    @Step("Кликнуть по ссылке 'Подробнее о сервисе'")
    public void clickDetailsLink() {
        detailsLink.clickDetailsLink();
    }

    @Step("Проверить, что блок 'Оплата банковской картой' отображается")
    public void verifyPageTitleDisplayed() {
        Assertions.assertTrue(detailsLink.isPageTitleDisplayed(),
                "Блок 'Оплата банковской картой' не отображается");
        System.out.println("Блок 'Оплата банковской картой' отображается");
    }

    @Step("Проверить текст заголовка")
    public void verifyPageTitleText(String expectedTitle) {
        String actualTitle = detailsLink.getPageTitleText();
        Assertions.assertEquals(expectedTitle, actualTitle,
                "Текст заголовка не соответствует ожидаемому");
        System.out.println("Текст заголовка: " + actualTitle);
    }
}
