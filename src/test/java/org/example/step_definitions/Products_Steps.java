package org.example.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.example.pages.ProductDetailPage;
import org.example.pages.ProductsPage;
import org.example.utility.Add;
import org.example.utility.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Products_Steps {

    private WebDriver driver;

    private ProductsPage productsPage;

    private HomePage homePage;

    private ProductDetailPage productDetailPage;

    private CartPage cartPage;

    public Products_Steps(Common_Steps common_steps) {
        this.driver = common_steps.getWebDriver();
        this.productsPage = new ProductsPage(driver);
        this.homePage = new HomePage(driver);
        this.productDetailPage = new ProductDetailPage(driver);
        this.cartPage = new CartPage(driver);

    }


    @When("I go to the Products Page and verify that list of products is visible")
    public void i_go_to_the_products_page_and_verify_that_list_of_products_is_visible() {
        homePage.verifyIfThePageIsVisible();
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

    @When("I add two of the products from the list to the cart")
    public void i_add_two_of_the_products_from_the_list_to_the_cart() {
        productsPage.addFirstTwoProductsToCart();
        Add.closeAdd(driver);
        homePage.clickOnTheCartIcon();
        Add.closeAdd(driver);
        if (driver.getCurrentUrl().equals(URL.HOME_PAGE_URL + URL.PRODUCTS_PAGE_URL_ENDING + URL.ADD_URL_ENDING)) {
            homePage.clickOnTheCartIcon();
            Add.closeAdd(driver);
        }
    }

    @Then("I verify that the products are added to the cart and remove products from the cart and verify that the cart is empty")
    public void i_verify_that_the_products_are_added_to_the_cart_and_remove_products_from_the_cart_and_verify_that_the_cart_is_empty() {
        Assert.assertTrue(cartPage.verifySizeOfCartInfoTable());
        Assert.assertTrue(cartPage.verifyCart());
        cartPage.removeFromCart();
        Add.closeAdd(driver);
        if (driver.getCurrentUrl().equals(URL.HOME_PAGE_URL + URL.CART_PAGE_URL_ENDING + URL.ADD_URL_ENDING)) {
            cartPage.removeFromCart();
            Add.closeAdd(driver);
        }
        Assert.assertTrue(cartPage.verifyEmptyCart());

    }


}
