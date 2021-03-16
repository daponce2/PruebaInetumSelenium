package com.bdd.web.step;

import com.bdd.Constants;
import com.bdd.Util;
import com.bdd.web.page.GooglePage;
import cucumber.api.Scenario;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;
import web.com.bdd.lib.WebDriverManager;
import web.com.bdd.util.UtilWeb;

import java.util.concurrent.TimeUnit;

public class GoogleStep {

    private GooglePage googlePage;
    private EnvironmentVariables environmentVariables;

    @Step("Abrir pagina de google")
    public void abrirPaginaGoogle() throws Exception{
        googlePage.setDriver(WebDriverManager.setWebDriverFromEnvironment(environmentVariables));
        googlePage.open();
        Util.screenshot(googlePage.getDriver());
        googlePage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Step("Realizar una busqueda")
    public void realizarBusqueda(String dato){
        googlePage.escribirBusqueda(dato);
        googlePage.clickBuscar();
    }

    @Step("Obtener resultados de busqueda")
    public String obtenerResultadosBusqueda(){
        return googlePage.obtenerResultadosBusqueda();
    }
}
