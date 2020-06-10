package web.com.bdd.base;


import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import static java.lang.Thread.sleep;

public class BaseDom extends PageObject {

    protected void implicitWait(int timeOnSeconds) {
        try {
            sleep(timeOnSeconds * 1000);
        } catch (Exception e) {
            System.out.println("Error implicitWaitDriver: " + e.getMessage());
        }
    }

     protected WebElement webDriverWait(WebElement element, int timeOnSeconds){
        return new WebDriverWait(getDriver(), timeOnSeconds).until(ExpectedConditions.visibilityOf(element));
    }

     protected WebElement winiumDriverWait(WebElement element, int timeOnSeconds) throws Throwable{
        return null;
        /*return new WebDriverWait(WiniumDriverManager.GetWiniumDriver(),
                timeOnSeconds).until(ExpectedConditions.visibilityOf(element));*/
    }

    protected static Robot robotDriver()throws AWTException {
        return new Robot();
    }

}
