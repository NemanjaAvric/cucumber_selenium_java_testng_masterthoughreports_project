package org.example.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.example.utility.Add;
import org.example.utility.URL;
import org.openqa.selenium.WebDriver;

public class Login_Steps {

    private WebDriver driver;

    private SignupLoginPage signupLoginPage;

    private HomePage homePage;

    private AccountDeletedPage accountDeletedPage;

    public Login_Steps(Common_Steps common_steps) {
        this.driver = common_steps.getWebDriver();
        this.signupLoginPage = new SignupLoginPage(driver);
        this.homePage = new HomePage(driver);
        this.accountDeletedPage = new AccountDeletedPage(driver);
    }

    @When("I login with valid email: {string} and valid password: {string}")
    public void i_login_with_valid_email_and_valid_password(String email, String password) {
        homePage.clcikSignupLoginButton();
        Add.closeAdd(driver);
        signupLoginPage.login(email, password);
        Add.closeAdd(driver);
    }

    @When("Verify that I'm logged in")
    public void verify_that_i_m_logged_in() {
        Add.closeAdd(driver);
        homePage.verifyThatUserIsLoggedIn();
    }

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
