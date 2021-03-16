package com.bdd.web.page;


import com.bdd.Constants;
import com.bdd.Util;
import cucumber.api.Scenario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;
import web.com.bdd.base.Middleware;

@DefaultUrl("https://www.google.com/")
public class GooglePage extends Middleware {

    @FindBy(xpath = "//input[@title='Buscar']")
    private WebElementFacade editTextBuscar;

    @FindBy(xpath = "//input[@value='Buscar con Google']")
    private WebElementFacade buscarBoton;

    @FindBy(id = "result-stats")
    private WebElementFacade resultadosLabel;

    public void escribirBusqueda(String dato){

        sendKeyElement(editTextBuscar, dato);
        Util.screenshot(getDriver());
    }

    public void clickBuscar(){
        clickElement(buscarBoton);
        Util.screenshot(getDriver());
    }

    public String obtenerResultadosBusqueda(){
        Util.screenshot(getDriver());
        return getTextFromElement(resultadosLabel);
    }

}
