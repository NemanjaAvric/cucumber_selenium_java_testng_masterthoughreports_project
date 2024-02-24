package org.example.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.ProductDetailPage;
import org.example.pages.ProductsPage;
import org.example.utility.Add;
import org.example.utility.URL;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Products_Steps {

    private WebDriver driver;

    private ProductsPage productsPage;

    private HomePage homePage;

    private ProductDetailPage productDetailPage;

    public Products_Steps(Common_Steps common_steps) {
        this.driver = common_steps.getWebDriver();
        this.productsPage = new ProductsPage(driver);
        this.homePage = new HomePage(driver);
        this.productDetailPage = new ProductDetailPage(driver);

    }


    @When("I go to the Products Page and verify that list of products is visible")
    public void i_go_to_the_products_page_and_verify_that_list_of_products_is_visible() {
        homePage.clickProductsButton();
        Add.closeAdd(driver);
        if (driver.getCurrentUrl().equalsIgnoreCase(URL.HOME_PAGE_URL + URL.ADD_URL_ENDING)) {
            homePage.clickProductsButton();
            Add.closeAdd(driver);
        }
        productsPage.checkVisibilityOfProductsList();
        Assert.assertEquals(driver.getCurrentUrl(), URL.HOME_PAGE_URL + URL.PRODUCTS_PAGE_URL_ENDING);
    }

    @When("I click on the View Product button of the first product and go to the Product Detail Page")
    public void i_click_on_the_view_product_button_of_the_first_product_and_go_to_the_product_detail_page() {
        productsPage.clickViewProductButtonOfFirstProduct();
        Add.closeAdd(driver);
        if (driver.getCurrentUrl().equalsIgnoreCase(URL.HOME_PAGE_URL + URL.PRODUCTS_PAGE_URL_ENDING + URL.ADD_URL_ENDING)) {
            productsPage.clickViewProductButtonOfFirstProduct();
            Add.closeAdd(driver);
        }
        Assert.assertEquals(driver.getCurrentUrl(), URL.HOME_PAGE_URL + URL.PRODUCT1_DETAIL_PAGE_URL_ENDING);
    }

    @Then("I verify that the details of the Product Detail Page are visible")
    public void i_verify_that_the_details_of_the_product_detail_page_are_visible() {
        productDetailPage.verifyThatProductDetailsAreVisibleOnTheProductDetailPage();
    }

    @When("I search the name of the product: {string}")
    public void i_search_the_name_of_the_product(String productName) {
        Add.closeAdd(driver);
        productsPage.searchProduct(productName);
        Add.closeAdd(driver);
    }

    @Then("I verify that the results of the search is visible")
    public void i_verify_that_the_results_of_the_search_is_visible() {
        productsPage.verifyThatSearchResultsAreVisible();
    }

}
