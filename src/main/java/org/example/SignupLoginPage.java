package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class SignupLoginPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/h2")
    private WebElement newUserSignupInscription;
    @FindBy(name = "name")
    private WebElement nameInputField;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
    private WebElement emailInputField;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
    private WebElement signupButton;

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    public void signUp(String name, String email) {
        wait.until(ExpectedConditions.visibilityOf(newUserSignupInscription));
        wait.until(ExpectedConditions.elementToBeClickable(nameInputField));
        nameInputField.sendKeys(name);
        emailInputField.sendKeys(email);
        signupButton.click();
    }
}
