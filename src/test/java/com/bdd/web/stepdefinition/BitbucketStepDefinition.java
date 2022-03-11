
package com.bdd.web.stepdefinition;

import com.bdd.Constants;
import com.bdd.web.step.BitbucketStep;
import com.bdd.web.step.GoogleStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import web.com.bdd.lib.WebDriverManager;
import web.com.bdd.util.UtilWeb;

public class BitbucketStepDefinition {

    @Steps
    private BitbucketStep bitbucketStep;
    private Scenario scenario;

    @Dado("que abro la pagina del Bitbucket")
    public void queAbroLaPaginaDelBitbucket() throws Exception {
        bitbucketStep.openPage();

    }

    @Cuando("ingreso mis datos de usuario")
    public void ingresoMisDatosDeUsuario() {
        bitbucketStep.writeData();
    }

    @Entonces("valido que el mensaje de error: {string}")
    public void validoQueElMensajeDeError(String v) {
        Assert.assertEquals(bitbucketStep.validateMessageResult(), v);

    }
}
