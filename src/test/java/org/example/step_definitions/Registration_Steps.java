package org.example.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.example.utility.Add;
import org.example.utility.URL;
import org.openqa.selenium.WebDriver;

public class Registration_Steps {

    private WebDriver driver;

    private HomePage homePage;

    private CreateAccountPage createAccountPage;

    private SignupLoginPage signupLoginPage;

    private AccountCreatedPage accountCreatedPage;

    private AccountDeletedPage accountDeletedPage;


    public Registration_Steps(Common_Steps common_steps) {
        this.driver = common_steps.getWebDriver();
        this.homePage = new HomePage(driver);
        this.signupLoginPage = new SignupLoginPage(driver);
        this.createAccountPage = new CreateAccountPage(driver);
        this.accountCreatedPage = new AccountCreatedPage(driver);
        this.accountDeletedPage = new AccountDeletedPage(driver);
    }

    @Given("I am on the Home Page")
    public void i_am_on_the_home_page() {
        driver.get(URL.HOME_PAGE_URL);
        Add.closeAdd(driver);
    }

    @When("I Sign up using {string} as username and {string} as email")
    public void i_sign_up_using_and(String username, String password) {
        homePage.clcikSignupLoginButton();
        Add.closeAdd(driver);
        signupLoginPage.signUp(username, password);
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

    @When("Verify that account is created and I'm logged in")
    public void verify_that_account_is_created_and_i_m_logged_in() {
        accountCreatedPage.verifyAccountCreatedInscriptionAndClickContinueButton();
        Add.closeAdd(driver);
        if (driver.getCurrentUrl().equals(URL.ACCOUNT_CREATED_PAGE_URL)) {
            accountCreatedPage.clickContinueButton();
        }
        Add.closeAdd(driver);
        homePage.verifyThatUserIsLoggedIn();
    }

    /*  @Then("Delete the account")
      public void delete_the_account() {
          Add.closeAdd(driver);
          if (driver.getCurrentUrl().endsWith(URL.ADD_URL_ENDING)) {
              homePage.clickDeleteAccount();
          }
          homePage.clickDeleteAccount();
          if (driver.getCurrentUrl().endsWith(URL.ADD_URL_ENDING)) {
              homePage.clickDeleteAccount();
          }
          Add.closeAdd(driver);
          accountDeletedPage.confirmAccountDeleted();
          Add.closeAdd(driver);
      }*/
    @Then("Delete the account")
    public void delete_the_account() {
        Add.closeAdd(driver);
        homePage.clickDeleteAccount();
        Add.closeAdd(driver);
        if (driver.getCurrentUrl().endsWith(URL.ADD_URL_ENDING)) {
            homePage.clickDeleteAccount();
        }
        Add.closeAdd(driver);
        accountDeletedPage.confirmAccountDeleted();
        Add.closeAdd(driver);
        if (driver.getCurrentUrl().endsWith(URL.ADD_URL_ENDING)) {
            accountDeletedPage.confirmAccountDeleted();
        }
        Add.closeAdd(driver);
    }
}


