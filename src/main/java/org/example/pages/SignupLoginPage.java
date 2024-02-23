package org.example.pages;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupLoginPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/h2")
    private WebElement newUserSignupInscription;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/h2")
    private WebElement loginToYourAccountInscription;
    @FindBy(name = "name")
    private WebElement nameInputField;
    @FindBy(name = "password")
    private WebElement passwordInputField;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
    private WebElement signUpEmailInputField;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
    private WebElement signupButton;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
    private WebElement loginEmailInputField;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/p")
    private WebElement yourEmailOrPasswordIsIncorrectInscription;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/p")
    private WebElement emailAlreadyExistsIncription;

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    public void signUp(String name, String email) {
        wait.until(ExpectedConditions.visibilityOf(newUserSignupInscription));
        wait.until(ExpectedConditions.elementToBeClickable(nameInputField));
        nameInputField.sendKeys(name);
        signUpEmailInputField.sendKeys(email);
        signupButton.click();
    }

    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(loginToYourAccountInscription));
        wait.until(ExpectedConditions.elementToBeClickable(loginEmailInputField));
        loginEmailInputField.sendKeys(email);
        passwordInputField.sendKeys(password);
        loginButton.click();
    }

    public void verifyYourEmailOrPasswordIsIncorrectInscriptionIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(yourEmailOrPasswordIsIncorrectInscription));
    }

    public void verifyEmailAlreadyExistsIncriptionIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(emailAlreadyExistsIncription));
    }
}
