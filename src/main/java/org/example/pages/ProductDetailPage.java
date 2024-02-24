package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPage extends AbstractPage {
    @FindBy(css = "div.product-information > h2")
    private WebElement itemName;
    @FindBy(css = "div.product-information > p:first-of-type")
    private WebElement itemCategory;
    @FindBy(css = "div.product-information > span > span")
    private WebElement priceOfAnItem;
    @FindBy(css = "div.product-information > p:nth-of-type(2)")
    private WebElement itemAvailability;
    @FindBy(css = "div.product-information > p:nth-of-type(3)")
    private WebElement itemCondition;
    @FindBy(css = "div.product-information > p:nth-of-type(4)")
    private WebElement itemBrand;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void verifyThatProductDetailsAreVisibleOnTheProductDetailPage() {
        wait.until(ExpectedConditions.visibilityOf(itemName));
        wait.until(ExpectedConditions.visibilityOf(itemCategory));
        wait.until(ExpectedConditions.visibilityOf(priceOfAnItem));
        wait.until(ExpectedConditions.visibilityOf(itemAvailability));
        wait.until(ExpectedConditions.visibilityOf(itemCondition));
        wait.until(ExpectedConditions.visibilityOf(itemBrand));
    }
}
