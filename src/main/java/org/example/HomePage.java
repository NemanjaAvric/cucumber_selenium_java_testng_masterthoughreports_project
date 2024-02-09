package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")
    private WebElement categoriesButton;

    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[2]/ul/li[1]/a")
    private WebElement handTools;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void goToHandToolsPage() {
        categoriesButton.click();
        handTools.click();
    }


    public WebElement getCategoriesButton() {
        return categoriesButton;
    }
}
