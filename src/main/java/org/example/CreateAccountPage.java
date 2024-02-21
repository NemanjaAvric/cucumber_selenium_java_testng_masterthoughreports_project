package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/h2/b")
    private WebElement enterAccountInformationInscription;
    @FindBy(id = "id_gender1")
    private WebElement titleGenderMale;
    @FindBy(id = "id_gender2")
    private WebElement titleGenderFemale;
    @FindBy(id = "name")
    private WebElement nameInputField;
    @FindBy(id = "email")
    private WebElement emailInputField;
    @FindBy(id = "password")
    private WebElement passwordInputField;
    @FindBy(id = "days")
    private WebElement daySelect;
    @FindBy(id = "months")
    private WebElement monthSelect;
    @FindBy(id = "years")
    private WebElement yearSelect;
    @FindBy(id = "newsletter")
    private WebElement signUpToOurNewsLatterCheckbox;
    @FindBy(id = "optin")
    private WebElement receiveSpecialOffersFromOurPartnersCheckbox;
    @FindBy(id = "first_name")
    private WebElement firstNameInputField;
    @FindBy(id = "last_name")
    private WebElement lastNameInputField;
    @FindBy(id = "company")
    private WebElement companyInptuField;
    @FindBy(id = "address1")
    private WebElement adress1InputField;
    @FindBy(id = "address2")
    private WebElement adress2InputFeild;
    @FindBy(id = "country")
    private WebElement countrySelect;
    @FindBy(id = "state")
    private WebElement stateInputField;
    @FindBy(id = "city")
    private WebElement cityInputField;
    @FindBy(id = "zipcode")
    private WebElement zipcodeInputField;
    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInputField;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/button")
    private WebElement createAccountButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTitleGenderMale() {
        return titleGenderMale;
    }

    public WebElement getTitleGenderFemale() {
        return titleGenderFemale;
    }

    public void createAccount(WebElement element,
                              String name,
                              String password,
                              int day,
                              String month,
                              int year,
                              String firstName,
                              String lastName,
                              String company,
                              String adress1,
                              String adress2,
                              String country,
                              String state,
                              String city,
                              int zipcode,
                              String mobileNumber) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(enterAccountInformationInscription));
        element.click();
        nameInputField.sendKeys(name);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", passwordInputField);
        passwordInputField.sendKeys(password);
        jsExecutor.executeScript("arguments[0].scrollIntoView();", daySelect);
        Select selectDay = new Select(daySelect);
        selectDay.selectByValue(day + "");
        Select selectMonth = new Select(monthSelect);
        selectMonth.selectByVisibleText(month);
        Select selectYear = new Select(yearSelect);
        selectYear.selectByValue(year + "");
        signUpToOurNewsLatterCheckbox.click();
        receiveSpecialOffersFromOurPartnersCheckbox.click();
        firstNameInputField.sendKeys(firstName);
        lastNameInputField.sendKeys(lastName);
        companyInptuField.sendKeys(company);
        jsExecutor.executeScript("window.scrollBy(0, 200);");
        adress1InputField.sendKeys(adress1);
        adress2InputFeild.sendKeys(adress2);
        jsExecutor.executeScript("arguments[0].scrollIntoView();", countrySelect);
        Select selectCountry = new Select(countrySelect);
        selectCountry.selectByValue(String.valueOf(country));
        stateInputField.sendKeys(state);
        cityInputField.sendKeys(city);
        zipcodeInputField.sendKeys(zipcode + "");
        mobileNumberInputField.sendKeys(mobileNumber);
        createAccountButton.click();
    }

}
