package com.bdd.web.stepdefinition;

import com.bdd.Constants;
import com.bdd.Util;
import com.bdd.web.step.GoogleStep;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import org.junit.Assert;

public class GoogleStepDefinition {

    @Steps
    private GoogleStep googleStep;
    private Scenario scenario;

    @Before
    public void before(Scenario scenario){
        this.scenario = scenario;
        Util.saveVariableOnSession(Constants.SCENARIO, this.scenario);
    }

    @Dado("que abro la pagina de Google$")
    public void que_abro_la_pagina_de_Google() throws Exception{
        googleStep.abrirPaginaGoogle();
    }

    @Cuando("realizo una busqueda \"([^\"]*)\"$")
    public void realizar_busqueda(String dato) {
        googleStep.realizarBusqueda(dato);
    }

    @Entonces("valido que el resultado de la busqueda sea \"([^\"]*)\"$")
    public void obtener_resultado(String resultado) {
        Assert.assertTrue(googleStep.obtenerResultadosBusqueda().length() > 0);
    }

}
