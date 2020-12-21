package com.bdd.web.page;


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
    }

    public void clickBuscar(){
        clickElement(buscarBoton);
    }

    public String obtenerResultadosBusqueda(){
        return getTextFromElement(resultadosLabel);
    }

}
