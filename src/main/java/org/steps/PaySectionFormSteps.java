package org.steps;

import org.page.PaySectionForm;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class PaySectionFormSteps {

    private final PaySectionForm paySectionForm;
    private final WebDriver driver;

    public PaySectionFormSteps(WebDriver driver) {
        this.driver = driver;
        this.paySectionForm = new PaySectionForm(driver);
    }

    @Step("Заполнить форму 'Услуги связи': телефон, сумма, email")
    public void fillConnectionPayForm(String phone, String sum, String email) {
        paySectionForm.enterConnectionPhone(phone);
        paySectionForm.enterConnectionSum(sum);
        paySectionForm.enterConnectionEmail(email);
    }

    @Step("Нажать кнопку 'Продолжить'")
    public BePaidAppFormSteps proceedConnectionPayForm() {
        paySectionForm.clickConnectionContinue();
        System.out.println("Нажата кнопка 'Продолжить'");
        return new BePaidAppFormSteps(driver);
    }

    @Step("Выбрать услугу")
    public void choosePayOption(String serviceName) {
        paySectionForm.openDropdownMenu();
        paySectionForm.selectServiceFromMenu(serviceName);
        System.out.println("Выбрана услуга: " + serviceName);
    }

    public String getFieldPlaceholder(String formId, String fieldType) {
        return paySectionForm.getFieldPlaceholder(formId, fieldType);
}
}

