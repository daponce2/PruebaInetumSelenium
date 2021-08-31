package com.bdd.web.stepdefinition;

import com.bdd.Constants;
import com.bdd.web.step.GoogleConfigStep;
import com.bdd.web.step.GoogleStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import web.com.bdd.lib.WebDriverManager;
import web.com.bdd.util.UtilWeb;

import static org.hamcrest.CoreMatchers.containsString;

public class GoogleStepDefinition {

    @Steps
    private GoogleStep googleStep;
    @Steps
    private GoogleConfigStep googleConfigStep;

    private Scenario scenario;

    @Before
    public void beforeGoogleStepDefinition(Scenario scenario) {
        this.scenario = scenario;
        UtilWeb.saveVariableOnSession(Constants.SCENARIO, this.scenario);
    }

    @After
    public void afterGoogleStepDefinition() {
        Scenario scenario = UtilWeb.getVariableOnSession(Constants.SCENARIO);
        if (scenario.isFailed()) UtilWeb.takeScreenShotWeb(scenario, WebDriverManager.getWebDriver());

        if (WebDriverManager.getWebDriver() != null)
            WebDriverManager.stopWebDriver();
    }

    @Dado("que abro la pagina de Google$")
    public void que_abro_la_pagina_de_Google() throws Exception {
        googleStep.abrirPaginaGoogle();
    }

    @Cuando("realizo una busqueda \"([^\"]*)\"$")
    public void realizar_busqueda(String dato) {
        googleStep.realizarBusqueda(dato);
    }

    @Entonces("valido que el resultado de la busqueda sea: \"([^\"]*)\"$")
    public void obtener_resultado(String resultado) {
        Assert.assertTrue(googleStep.obtenerResultadosBusqueda().length() > 0);
    }


    //CONFIGURACION GOOGLE - DEMO SHADOWROOT
    @Dado("que abro la pagina de configuracion de Google$")
    public void que_abro_la_pagina_de_confg_Google() throws Exception {
        googleConfigStep.abrirPaginaConfigGoogle();
    }

    @Cuando("busco la configuracion \"([^\"]*)\"$")
    public void busco_configuracion(String dato) {
        googleConfigStep.realizarBusqueda(dato);
    }

    @Entonces("valido que el resultado sea: \"([^\"]*)\"$")
    public void valido_resultado(String resultado) {
        Assert.assertEquals(resultado, googleConfigStep.busquedaExiste());
    }

    @Entonces("valido que el navegador sea: \"([^\"]*)\"$")
    public void obtengoOpciones(String var) {
        Assert.assertThat(googleConfigStep.obtenerResultado(), containsString(var));

    }


}
