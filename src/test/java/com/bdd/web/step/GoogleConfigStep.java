package com.bdd.web.step;

import com.bdd.web.page.GoogleConfigPage;

import ct.com.core.environment.ManageEnvironment;
import net.thucydides.core.annotations.Step;
import web.com.bdd.lib.WebDriverManager;
import web.com.bdd.util.UtilWeb;

import java.net.MalformedURLException;
import java.time.Duration;

public class GoogleConfigStep {

    private GoogleConfigPage googleConfigPage() {
        return new GoogleConfigPage();
    }

    @Step
    public void abrirPaginaConfigGoogle() throws MalformedURLException {
        WebDriverManager.setWebDriver(ManageEnvironment.getEnvironment());
        WebDriverManager.setUrl(UtilWeb.getStringEvironmentProperty(ManageEnvironment.getEnvironment(), "url.shadow"));
        WebDriverManager.maximizeWindows();
        Duration duration = Duration.ofSeconds(15);
        WebDriverManager.setDriverImplicitWait(duration);
    }

    @Step
    public void realizarBusqueda(String dato) {
        googleConfigPage().buscar(dato);
    }

    @Step
    public String busquedaExiste() {
        return googleConfigPage().getBusqueda();
    }

    @Step
    public String obtenerResultado() {
        return googleConfigPage().obtenerResultado();
    }
}
