package web.com.bdd.base;


import web.com.bdd.generic.WebDriverDOM;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseWebPage extends WebDriverDOM {

    @FindBy(xpath = "//div[@class='big-loading ng-star-inserted']")
    private WebElementFacade loading;

    protected void waitUntilOfficebankigLoadingIsNotVisible() {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 60);
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='big-loading ng-star-inserted']")));
        } catch (Exception e) {
            System.out.println("No se esperó a que se oculte la página de carga de Office Banking");
        }
    }




    protected void waitUntilOfficebankigLoadingIsVisible() {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 60);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='big-loading ng-star-inserted']")));
        } catch (Exception e) {
            System.out.println("No se mostró la página de carga de Office Banking");
        }
    }
    
    protected void waitUntilWiseInNotVisible(){
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 60);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='big-loading loading-zindex-1']")));
    }

}

