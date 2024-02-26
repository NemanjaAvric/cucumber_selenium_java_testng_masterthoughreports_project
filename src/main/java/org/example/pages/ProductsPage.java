package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class ProductsPage extends AbstractPage {

    @FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div")
    private WebElement productsList;
    @FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
    private WebElement viewProductButtonOfFirstProduct;
    @FindBy(id = "search_product")
    private WebElement searchProductBar;
    @FindBy(id = "submit_search")
    private WebElement submitSearchButton;
    @FindBy(xpath = "//h2[@class='title text-center']")
    private WebElement searchedProductsInscription;
    @FindBy(xpath = "//div[@class='productinfo text-center']")
    private List<WebElement> searchResults;
    @FindBy(xpath = "//a[@class='btn btn-default add-to-cart' and @data-product-id=1]")
    private WebElement firstAddToCartButton;

    @FindBy(xpath = "//a[@class='btn btn-default add-to-cart' and @data-product-id=2]")
    private WebElement secondAddToCartButton;
    @FindBy(className = "btn-success")
    private WebElement continueShoppingButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void checkVisibilityOfProductsList() {
        wait.until(ExpectedConditions.visibilityOf(productsList));
    }

    public void clickViewProductButtonOfFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(viewProductButtonOfFirstProduct));
        viewProductButtonOfFirstProduct.click();
    }

    public void searchProduct(String productName) {
        searchProductBar.sendKeys(productName);
        wait.until(ExpectedConditions.textToBePresentInElementValue(searchProductBar, productName));
        submitSearchButton.click();
        wait.until(ExpectedConditions.visibilityOf(searchedProductsInscription));
    }

    public void verifyThatSearchResultsAreVisible() {
        if (!searchResults.isEmpty()) {
            for (WebElement result : searchResults) {
                wait.until(ExpectedConditions.visibilityOf(result));
            }
        }
    }


    public void addFirstTwoProductsToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstAddToCartButton));
        firstAddToCartButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(secondAddToCartButton));
        secondAddToCartButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }

}
