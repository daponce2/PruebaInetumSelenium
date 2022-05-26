package com.bdd.web.page;

import com.bdd.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.com.bdd.base.Middleware;
import web.com.bdd.util.UtilWeb;

import java.time.Duration;
import java.util.logging.Level;

public class BitbucketPage extends Middleware {

    @FindBy(id = "j_username")
    private WebElement txtUserName;

    @FindBy(id = "j_password")
    private WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/section/div")
    private WebElement messageError;

    public void escribirUser(String u) {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Escribiendo usuario..");
        Util.screenshot(getDriver());
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(txtUserName)).sendKeys(u);
    }

    public void escribirPassword(String p) {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Escribiendo usuario..");
        Util.screenshot(getDriver());
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(txtPassword)).sendKeys(p);
    }

    public void clickLogin() {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en boton Login");
        Util.screenshot(getDriver());
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
    }


    public String getMessageError() {
        Util.screenshot(getDriver());
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Se obtiene el mensaje de la web: ", getTextFromElement(messageError));
        return getTextFromElement(messageError);
    }

}

