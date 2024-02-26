package org.example.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Subscription_Steps {
    private WebDriver driver;

    private HomePage homePage;

    public Subscription_Steps(Common_Steps common_steps) {
        this.driver = common_steps.getWebDriver();
        this.homePage = new HomePage(driver);
    }

    @When("I scroll down the page and subscribe using email: {string}")
    public void i_scroll_down_the_page_and_subscribe_using_email(String email) {
        homePage.verifyIfThePageIsVisible();
        homePage.waitForSubscriptionInscriptionToBePresentOnThePage();
        Assert.assertEquals(homePage.getSubscriptionInscription().getText(), "SUBSCRIPTION");
        homePage.subscribe(email);
    }

    @Then("I verify that I have been successfully subscribed")
    public void i_verify_that_i_have_been_successfully_subscribed() {
        homePage.verifyThatYouHaveBeenSuccessfullySubscribedInscriptionIsVisible();
    }
}
