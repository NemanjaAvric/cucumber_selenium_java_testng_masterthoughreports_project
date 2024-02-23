package org.example.pages;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    private WebElement signupLoginButton;
    @FindBy(id = "header")
    private WebElement header;
    @FindBy(xpath = "/html/body")
    private WebElement body;
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    private WebElement loggedInAsUsernameInscription;
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    private WebElement deleteAccountButton;
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    private WebElement logoutButton;
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")
    private WebElement contactUsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void verifyIfThePageIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(header));
        wait.until(ExpectedConditions.visibilityOf(body));
    }

    public void clcikSignupLoginButton() {
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        verifyIfThePageIsVisible();
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginButton));
        signupLoginButton.click();
    }

    public void verifyThatUserIsLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(loggedInAsUsernameInscription));
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void clickDeleteAccount() {
        deleteAccountButton.click();
    }

    public void clickContactUsButton() {
        contactUsButton.click();
    }

}
