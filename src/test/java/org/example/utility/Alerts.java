package org.example.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class Alerts {

    public static void acceptAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static boolean isAlertPresent(WebDriver driver) {
        boolean presentFlag = false;

        try {
            Alert alert = driver.switchTo().alert();
            presentFlag = true;
            alert.accept();

        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
        }
        return presentFlag;
    }
}
