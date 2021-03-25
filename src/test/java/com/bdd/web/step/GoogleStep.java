package com.bdd.web.step;

import com.bdd.Util;
import com.bdd.web.page.GooglePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import web.com.bdd.lib.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class GoogleStep {

    private GooglePage googlePage;
    private EnvironmentVariables environmentVariables;

    @Step("Abrir pagina de google")
    public void abrirPaginaGoogle() throws Exception{
        googlePage.setDriver(WebDriverManager.setWebDriverFromEnvironment(environmentVariables));
        googlePage.open();
        googlePage.getDriver().manage().window().maximize();
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
