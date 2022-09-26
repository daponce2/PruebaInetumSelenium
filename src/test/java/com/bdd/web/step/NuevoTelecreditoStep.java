package com.bdd.web.step;

import com.bdd.web.page.NuevoTelecreditoPage;
import ct.com.core.environment.ManageEnvironment;
import net.thucydides.core.annotations.Step;
import web.com.bdd.lib.WebDriverManager;
import web.com.bdd.util.UtilWeb;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class NuevoTelecreditoStep {

    private NuevoTelecreditoPage nuevoTelecreditoPage() {
        return new NuevoTelecreditoPage();
    }

    @Step("Ingresar a la web de NTLC")
    public void ingresarWebNTLC() throws MalformedURLException {
        WebDriverManager.setWebDriver(ManageEnvironment.getEnvironment());
        String url = UtilWeb.getStringEvironmentProperty(ManageEnvironment.getEnvironment(), "url.tlcbcp");
        WebDriverManager.setUrl(url);
        Duration duration = Duration.ofSeconds(10);
        WebDriverManager.getWebDriver().manage().timeouts().implicitlyWait(duration);
        WebDriverManager.getWebDriver().manage().window().maximize();
    }

    @Step("Ingresar Tarjeta y Clave")
    public void ingresarTarjetayClave(String getTarjeta, String getClave) throws IOException, InterruptedException {
        nuevoTelecreditoPage().ingresarTarjetayClave(getTarjeta, getClave);
    }

    @Step("Clic en el boton Ingresar")
    public void clicBotonIngresar() {
        nuevoTelecreditoPage().clicBotonIngresar();
    }


}
