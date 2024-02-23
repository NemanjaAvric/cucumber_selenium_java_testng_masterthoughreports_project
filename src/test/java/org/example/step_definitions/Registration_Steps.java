package org.example.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.AccountCreatedPage;
import org.example.pages.CreateAccountPage;
import org.example.pages.HomePage;
import org.example.pages.SignupLoginPage;
import org.example.utility.Add;
import org.example.utility.URL;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Registration_Steps {

    private WebDriver driver;

    private HomePage homePage;

    private CreateAccountPage createAccountPage;

    private SignupLoginPage signupLoginPage;

    private AccountCreatedPage accountCreatedPage;


    public Registration_Steps(Common_Steps common_steps) {
        this.driver = common_steps.getWebDriver();
        this.homePage = new HomePage(driver);
        this.signupLoginPage = new SignupLoginPage(driver);
        this.createAccountPage = new CreateAccountPage(driver);
        this.accountCreatedPage = new AccountCreatedPage(driver);
    }


    @When("I Sign up using {string} as username and {string} as email")
    public void i_sign_up_using_and(String username, String email) {
        homePage.clcikSignupLoginButton();
        Add.closeAdd(driver);
        signupLoginPage.signUp(username, email);
        Add.closeAdd(driver);
    }

    @When("Create an account using following data: {string}, {string}, {string}, {int}, {string}, {int}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} {int}, {string}")
    public void create_an_account_using_following_data(String title, String name, String password, Integer day, String month, Integer year, String firstName, String lastName, String company, String adress1, String adress2, String country, String state, String city, Integer zipcode, String mobilenumber) throws InterruptedException {
        if (title.equals("Mr.")) {
            createAccountPage.createAccount(createAccountPage.getTitleGenderMale(), name, password, day, month, year, firstName, lastName, company, adress1, adress2, country, state, city, zipcode, mobilenumber);
            Add.closeAdd(driver);
        } else if (title.equals("Mrs.")) {
            createAccountPage.createAccount(createAccountPage.getTitleGenderFemale(), name, password, day, month, year, firstName, lastName, company, adress1, adress2, country, state, city, zipcode, mobilenumber);
            Add.closeAdd(driver);
        }
    }

    @When("Verify that account is created and that I'm logged in")
    public void verify_that_account_is_created_and_i_m_logged_in() {
        accountCreatedPage.verifyAccountCreatedInscriptionAndClickContinueButton();
        Add.closeAdd(driver);
        if (driver.getCurrentUrl().equals(URL.ACCOUNT_CREATED_PAGE_URL)) {
            accountCreatedPage.clickContinueButton();
        }
        Add.closeAdd(driver);
        homePage.verifyThatUserIsLoggedIn();
    }

    @Then("Verify that account with that email already exists")
    public void verify_that_account_with_that_email_already_exists() {
        signupLoginPage.verifyEmailAlreadyExistsIncriptionIsVisible();
        Assert.assertEquals(driver.getCurrentUrl(), URL.SIGNUP_PAGE_URL);
    }

    @Then("Logout")
    public void log_out() {
        Add.closeAdd(driver);
        homePage.clickLogoutButton();
        Add.closeAdd(driver);
        if (driver.getCurrentUrl().endsWith(URL.ADD_URL_ENDING)) {
            homePage.clickLogoutButton();
        }
        Add.closeAdd(driver);
    }
}


