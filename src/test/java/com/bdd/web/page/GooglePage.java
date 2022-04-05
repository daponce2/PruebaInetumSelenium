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

public class GooglePage extends Middleware {

    @FindBy(xpath = "//input[@title='Buscar']")
    private WebElement editTextBuscar;

    @FindBy(xpath = "//input[@value='Buscar con Google']")
    private WebElement buscarBoton;

    @FindBy(id = "result-stats")
    private WebElement resultadosLabel;

    public void escribirBusqueda(String dato) {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "escribirBusqueda");
        Util.screenshot(getDriver());
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editTextBuscar)).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "click");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editTextBuscar)).sendKeys(dato);
        Util.screenshot(getDriver());
        UtilWeb.logger(this.getClass()).log(Level.INFO, "escribirBusqueda");
    }

    public void clickBuscar() {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "clickBuscar");
        clickElement(buscarBoton);
        Util.screenshot(getDriver());
    }

    public String obtenerResultadosBusqueda() {
        Util.screenshot(getDriver());
        return getTextFromElement(resultadosLabel);
    }

}


