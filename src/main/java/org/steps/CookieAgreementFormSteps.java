package org.steps;

import org.page.CookieAgreementForm;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class CookieAgreementFormSteps {

    private final CookieAgreementForm cookieForm;

    public CookieAgreementFormSteps(WebDriver driver) {
        this.cookieForm = new CookieAgreementForm(driver);
    }

    @Step("Закрыть баннер с куками")
    public void closeCookieAgreement() {
        cookieForm.acceptCookies();
    }
}
