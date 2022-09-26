package com.bdd.web.stepdefinition;

import com.bdd.web.step.NuevoTelecreditoStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;
import java.net.MalformedURLException;

public class NuevoTelecreditoStepDefinition {

    @Steps
    private NuevoTelecreditoStep nuevoTelecreditoStep;
    private Scenario scenario;

    @Dado("que ingreso a la web de Telecredito")
    public void que_ingreso_a_la_web_de_telecredito() throws MalformedURLException {
        nuevoTelecreditoStep.ingresarWebNTLC();
    }

    @Cuando("ingreso la tarjeta {string} con clave {string} y el capctha")
    public void ingreso_la_tarjeta_con_clave_y_el_capctha(String sTarjeta, String sClave) throws IOException, InterruptedException {
        nuevoTelecreditoStep.ingresarTarjetayClave(sTarjeta, sClave);
    }

    @Entonces("valido la carga del Home de Telecredito")
    public void valido_la_carga_del_home_de_telecredito() {
        nuevoTelecreditoStep.clicBotonIngresar();
    }
}
