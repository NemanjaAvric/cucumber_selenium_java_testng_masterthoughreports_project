package org.example.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SubscriptionCartPage_Steps {

    private WebDriver driver;

    private HomePage homePage;

    private CartPage cartPage;

    public SubscriptionCartPage_Steps(Common_Steps common_steps) {
        this.driver = common_steps.getWebDriver();
        this.homePage = new HomePage(driver);
        this.cartPage = new CartPage(driver);
    }

    @When("I click on the Cart icon and go to the Cart Page")
    public void i_click_on_the_cart_icon_and_go_to_the_cart_page() {
        homePage.verifyIfThePageIsVisible();
        homePage.clickOnTheCartIcon();
    }

    @When("I subscribe using email: {string}")
    public void i_subscribe_using_email(String email) {
        cartPage.waitForSubscriptionInscriptionToBePresentOnThePage();
        Assert.assertEquals(cartPage.getSubscriptionInscription().getText(), "SUBSCRIPTION");
        cartPage.subscribe(email);
    }

    @Then("I verify that I have been successfully subscribed on the Cart Page")
    public void i_verify_that_i_have_been_successfully_subscribed_on_the_cart_page() {
        cartPage.verifyThatYouHaveBeenSuccessfullySubscribedInscriptionIsVisible();
    }
}
