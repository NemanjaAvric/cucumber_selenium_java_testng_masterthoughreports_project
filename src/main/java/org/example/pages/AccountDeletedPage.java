package org.example.pages;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDeletedPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    private WebElement accountDeletedInscription;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    private WebElement continueButton;


    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public void confirmAccountDeleted(){
        wait.until(ExpectedConditions.visibilityOf(accountDeletedInscription));
        continueButton.click();
    }
}
