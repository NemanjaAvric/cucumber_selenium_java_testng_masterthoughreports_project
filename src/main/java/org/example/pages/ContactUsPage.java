package org.example.pages;

import com.aventstack.extentreports.util.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2")
    private WebElement getInTouchInscription;
    @FindBy(name = "name")
    private WebElement nameInputField;

    @FindBy(name = "email")
    private WebElement emailInputField;

    @FindBy(name = "subject")
    private WebElement subjectInputField;
    @FindBy(id = "message")
    private WebElement yourMessageHereInputField;
    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[5]/input")
    private WebElement uploadFile;

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[6]/input")
    private WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")
    private WebElement successMessage;
    @FindBy(xpath = "//*[@id=\"form-section\"]/a")
    private WebElement homeButton;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void fillOutAndSendContactForm(String name, String email, String subject, String message) {
        nameInputField.sendKeys(name);
        emailInputField.sendKeys(email);
        subjectInputField.sendKeys(subject);
        yourMessageHereInputField.sendKeys(message);
        wait.until(ExpectedConditions.elementToBeClickable(uploadFile));
        String projectRoot = System.getProperty("user.dir");
        String filePath = projectRoot + "\\src\\test\\resources\\files\\Message.txt";
        uploadFile.sendKeys(filePath);
        submitButton.click();
    }

    public void verifyThatContactFormHasBeenSentAndGoToHomePage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        homeButton.click();
    }

    public void verifyThatGetInTouchInscriptionIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(getInTouchInscription));
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
