package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountCreatedPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    private WebElement accountCreatedInscription;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    private WebElement continueButton;

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public void verifyAccountCreatedInscriptionAndClickContinueButton() {
        wait.until(ExpectedConditions.visibilityOf(accountCreatedInscription));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }


}
