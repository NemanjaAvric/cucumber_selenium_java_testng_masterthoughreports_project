package org.example.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.HandToolsPage;
import org.example.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CategoriesDropdown_Steps {

    private WebDriver driver;

    private HomePage homePage;

    private HandToolsPage handToolsPage;

    private final String HOME_PAGE_URL = "https://practicesoftwaretesting.com/#/";

    public CategoriesDropdown_Steps(Common_Steps common_steps) {
        this.driver = common_steps.getWebDriver();
        this.homePage = new HomePage(driver);
        this.handToolsPage = new HandToolsPage(driver);
    }

    @Given("I am on the Home Page")
    public void i_am_on_the_home_page() {
        driver.get(HOME_PAGE_URL);
    }

    @When("I click on the Categories button and pick Hand Tools Category")
    public void i_click_on_the_categories_button_and_pick_hand_tools_category() {
        homePage.goToHandToolsPage();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("Pick {string} Category")
    public void pick_category(String string) {
        handToolsPage.checkTheCheckBox(string);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("only {int} {string} should appear on page and nothing else")
    public void only_should_appear_on_page_and_nothing_else(Integer int1, String string) {
        Assert.assertEquals(handToolsPage.getItems().size(), int1);
        Assert.assertTrue(handToolsPage.checkNames(string));

    }
}


