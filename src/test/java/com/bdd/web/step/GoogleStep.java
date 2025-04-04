package com.bdd.web.step;

import com.bdd.web.page.GooglePage;
import ct.com.core.environment.ManageEnvironment;
import net.thucydides.core.annotations.Step;
import web.com.bdd.lib.WebDriverManager;
import web.com.bdd.util.UtilWeb;

import java.time.Duration;

public class GoogleStep {

    private GooglePage googlePage() {
        return new GooglePage();
    }

    @Step("Abrir pagina de google")
    public void abrirPaginaGoogle() throws Exception {
        WebDriverManager.setWebDriver(ManageEnvironment.getEnvironment());
        String url = UtilWeb.getStringEvironmentProperty(ManageEnvironment.getEnvironment(), "url.google");
        WebDriverManager.setUrl(url);
        Duration duration = Duration.ofSeconds(10);
        WebDriverManager.getWebDriver().manage().timeouts().implicitlyWait(duration);

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

    @Step
    public void abrirPaginaConfigGoogle() {

    }
}
