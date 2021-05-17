package com.bdd.web.step;

import com.bdd.web.page.GooglePage;
import environment.ManageEnvironment;
import net.thucydides.core.annotations.Step;
import web.com.bdd.lib.WebDriverManager;
import web.com.bdd.util.UtilWeb;

import java.util.concurrent.TimeUnit;

public class GoogleStep {

    private GooglePage googlePage() {
        return new GooglePage();
    }
    //private EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    @Step("Abrir pagina de google")
    public void abrirPaginaGoogle() throws Exception {
       /* googlePage.setDriver(WebDriverManager.setWebDriverFromEnvironment(environmentVariables));
        googlePage.open();
        googlePage.getDriver().manage().window().maximize();
        Util.screenshot(googlePage.getDriver());
        googlePage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/

        WebDriverManager.setWebDriver(ManageEnvironment.getEnvironmentVariables());
        String url = UtilWeb.getEnvironmentValuePropertie(ManageEnvironment.getEnvironmentVariables(), "urlBASE");
        WebDriverManager.setUrl(url);
        WebDriverManager.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Step("Realizar una busqueda")
    public void realizarBusqueda(String dato) {
        googlePage().escribirBusqueda(dato);
        googlePage().clickBuscar();
    }

    @Step("Obtener resultados de busqueda")
    public String obtenerResultadosBusqueda() {
        return googlePage().obtenerResultadosBusqueda();
    }
}
