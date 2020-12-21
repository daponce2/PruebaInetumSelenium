package com.bdd.web.step;

import com.bdd.web.page.GooglePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;
import web.com.bdd.lib.WebDriverManager;

public class GoogleStep extends ScenarioSteps {

    private GooglePage googlePage;
    private EnvironmentVariables environmentVariables;

    @Step("Abrir pagina de google")
    public void abrirPaginaGoogle() throws Exception{
        googlePage.setDriver(WebDriverManager.setWebDriverFromEnvironment(environmentVariables));
        googlePage.open();
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
