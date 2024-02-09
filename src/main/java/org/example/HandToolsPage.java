package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HandToolsPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"filters\"]/div[1]/ul/div/label/input")
    private List<WebElement> checkBoxes;
    @FindBy(xpath = "/html/body/app-root/div/app-category/div[2]/div[2]/div[1]/a/div[2]/h5")
    private List<WebElement> items;

    public HandToolsPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getItems() {
        return items;
    }


    public boolean checkNames(String string) {
        for (WebElement element : items) {
            String actual = element.getText().toLowerCase().trim();
            String expeceted = string.toLowerCase().trim();
            if (!actual.contains(expeceted)) {
                return false;
            }
        }
        return true;
    }

    public void checkTheCheckBox(String string) {
        String newString = string.toLowerCase().trim();
        switch (newString) {
            case "hammer":
                checkBoxes.get(0).click();
                break;
            case "hand saw":
                checkBoxes.get(1).click();
                break;
            case "wrench":
                checkBoxes.get(2).click();
                break;
            case "screwdriver":
                checkBoxes.get(3).click();
                break;
            case "pilers":
                checkBoxes.get(4).click();
                break;
            case "chisels":
                checkBoxes.get(5).click();
                break;
            case "measures":
                checkBoxes.get(6).click();
                break;
        }
    }
}
