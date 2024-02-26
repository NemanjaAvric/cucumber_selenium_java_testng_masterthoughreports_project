package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
    private WebElement subscriptionInscription;

    @FindBy(id = "susbscribe_email")
    private WebElement subscriptionInputField;

    @FindBy(id = "subscribe")
    private WebElement subscriptionButton;

    @FindBy(xpath = "//*[@id=\"success-subscribe\"]/div")
    private WebElement youHaveBeenSuccessfullySubscribedInscription;
    @FindBy(xpath = "//*[contains(@id, 'product')]")
    private List<WebElement> cartInfoTable;
    @FindBy(xpath = "//*[@id=\"product-1\"]/td[2]/h4/a")
    private WebElement nameOfFirstItemInCart;
    @FindBy(xpath = "//*[@id=\"product-2\"]/td[2]/h4/a")
    private WebElement nameOfSecondItemInCart;
    @FindBy(xpath = "//*[@id=\"product-1\"]/td[3]/p")
    private WebElement priceOfFirstItem;
    @FindBy(xpath = "//*[@id=\"product-2\"]/td[3]/p")
    private WebElement priceOfSecondItem;
    @FindBy(xpath = "//*[@id=\"product-1\"]/td[4]/button")
    private WebElement quantityOfFirstItem;
    @FindBy(xpath = "//*[@id=\"product-2\"]/td[4]/button")
    private WebElement quantityOfSecondItem;
    @FindBy(xpath = "//*[@id=\"product-1\"]/td[5]/p")
    private WebElement totalPriceOfFirstItem;
    @FindBy(xpath = "//*[@id=\"product-2\"]/td[5]/p")
    private WebElement totalPriceOfSecondItem;
    @FindBy(xpath = "//*[@id=\"product-1\"]/td[6]/a/i")
    private WebElement removeFromCartFirstItem;
    @FindBy(xpath = "//*[@id=\"product-2\"]/td[6]/a/i")
    private WebElement removeFromCartSecondItem;
    @FindBy(xpath = "//*[@id=\"empty_cart\"]/p/b")
    private WebElement emptyCart;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void waitForSubscriptionInscriptionToBePresentOnThePage() {
        wait.until(ExpectedConditions.visibilityOf(subscriptionInscription));
    }

    public WebElement getSubscriptionInscription() {
        return subscriptionInscription;
    }

    public void subscribe(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(subscriptionInputField));
        subscriptionInputField.sendKeys(email);
        subscriptionButton.click();
    }

    public void verifyThatYouHaveBeenSuccessfullySubscribedInscriptionIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(youHaveBeenSuccessfullySubscribedInscription));
    }

    public boolean verifySizeOfCartInfoTable() {
        return cartInfoTable.size() == 2;
    }

    public boolean verifyCart() {
        boolean condition1 = false;
        boolean condition2 = false;
        if (nameOfFirstItemInCart.getText().equals("Blue Top") && priceOfFirstItem.getText().equals("Rs. 500") && quantityOfFirstItem.getText().equals("1") && totalPriceOfFirstItem.getText().equals("Rs. 500")) {
            condition1 = true;
        }

        if (nameOfSecondItemInCart.getText().equals("Men Tshirt") && priceOfSecondItem.getText().equals("Rs. 400") && quantityOfSecondItem.getText().equals("1") && totalPriceOfSecondItem.getText().equals("Rs. 400")) {
            condition2 = true;
        }

        return condition1 && condition2;
    }

    public void removeFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(removeFromCartSecondItem));
        removeFromCartSecondItem.click();
        wait.until(ExpectedConditions.elementToBeClickable(removeFromCartFirstItem));
        removeFromCartFirstItem.click();
    }

    public boolean verifyEmptyCart() {
        wait.until(ExpectedConditions.visibilityOf(emptyCart));
        return emptyCart.getText().equals("Cart is empty!");
    }
}
