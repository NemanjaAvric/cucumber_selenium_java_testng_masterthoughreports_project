package org.example.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.ContactUsPage;
import org.example.pages.HomePage;
import org.example.utility.Add;
import org.example.utility.Alerts;
import org.example.utility.URL;
import org.openqa.selenium.*;
import org.testng.Assert;

public class ContactUs_Steps {

    private WebDriver driver;

    private HomePage homePage;

    private ContactUsPage contactUsPage;


    public ContactUs_Steps(Common_Steps common_steps) {
        this.driver = common_steps.getWebDriver();
        this.homePage = new HomePage(driver);
        this.contactUsPage = new ContactUsPage(driver);
    }

    @When("I navigate to the Contact us page, fill out the contact form and send it")
    public void i_navigate_to_the_contact_us_page_fill_out_the_contact_form_and_send_it() {
        homePage.verifyIfThePageIsVisible();
        homePage.clickContactUsButton();
        Add.closeAdd(driver);
        contactUsPage.verifyThatGetInTouchInscriptionIsVisible();
        Add.closeAdd(driver);
    }

    @Then("I verify that the form has been sent")
    public void i_verify_that_the_form_has_been_sent() throws InterruptedException {
        contactUsPage.fillOutAndSendContactForm("Nemanja", "gojoSatoru@jjk.com", "Toto-Cursed Technique", "Hold the line!!!");
        Assert.assertTrue(Alerts.isAlertPresent(driver));
        Add.closeAdd(driver);
        contactUsPage.verifyThatContactFormHasBeenSentAndGoToHomePage();
        Add.closeAdd(driver);
        if (driver.getCurrentUrl().equals(URL.HOME_PAGE_URL + URL.CONTACT_US_PAGE_URL_ENDING + URL.ADD_URL_ENDING)) {
            contactUsPage.verifyThatContactFormHasBeenSentAndGoToHomePage();
            Add.closeAdd(driver);
        }
        Assert.assertEquals(driver.getCurrentUrl(), URL.HOME_PAGE_URL);
    }



}
