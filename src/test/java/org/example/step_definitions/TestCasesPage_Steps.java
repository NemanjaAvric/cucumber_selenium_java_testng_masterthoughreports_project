package org.example.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.utility.Add;
import org.example.utility.URL;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCasesPage_Steps {

    private HomePage homePage;
    private WebDriver driver;

    public TestCasesPage_Steps(Common_Steps common_steps) {
        this.driver = common_steps.getWebDriver();
        this.homePage = new HomePage(driver);
    }

    @When("I click on Test Cases button and go to the Test Cases page")
    public void i_click_on_test_cases_button_and_go_to_the_test_cases_page() {
        homePage.verifyIfThePageIsVisible();
        homePage.clickTestCasesButton();
        Add.closeAdd(driver);
        if (driver.getCurrentUrl().equals(URL.HOME_PAGE_URL + URL.ADD_URL_ENDING)) {
            homePage.clickTestCasesButton();
        }
    }

    @Then("I verify that I have navigated to Test Cases page successfully")
    public void i_verify_that_i_have_navigated_to_test_cases_page_successfully() {
        Add.closeAdd(driver);
        Assert.assertEquals(driver.getCurrentUrl(), URL.HOME_PAGE_URL + URL.TEST_CASES_PAGE_URL_ENDING);
    }

}
