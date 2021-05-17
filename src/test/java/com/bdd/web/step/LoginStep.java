package com.bdd.web.step;


import com.bdd.Util;
import com.bdd.web.page.LoginPage;
import environment.EnvironmentSpecificConfiguration;
import environment.EnvironmentVariables;
import net.thucydides.core.annotations.Step;
import web.com.bdd.lib.WebDriverManager;

import java.net.MalformedURLException;

public class LoginStep {

    private LoginPage loginPage;
    EnvironmentVariables environmentVariables;

    @Step("Cargar página de OfficeBanking")
    public void cargarPaginaOfficeBanking() throws MalformedURLException {
       /* loginPage.setWebDriverFromEnvironment(environmentVariables);
        loginPage.open();*/
        String google = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("");

        WebDriverManager.setWebDriver(environmentVariables).get(google);
        loginPage.validarCargaPagina();

    }

    @Step("Seleccionar tipo de acceso")
    public void seleccionarTipoAcceso(String tipoAcceso) {
        loginPage.clickTipoAcceso(tipoAcceso);
    }

    @Step("Escribir la tarjeta")
    public void escribirTarjeta(String sTarjeta) {
        loginPage.ingresarTarjeta(sTarjeta);
    }

    @Step("Escribir la clave de internet")
    public void escribirClaveInternet(String sClaveInternet) {
        loginPage.ingresarClaveInternet(sClaveInternet);
    }

    @Step("Escribir capcha")
    public void escribirCaptcha(String sCaptcha) {
        loginPage.ingresarCaptcha(sCaptcha);
    }

    @Step("Click en el boton Ingresar")
    public void clickBotonIngresar() {
        loginPage.clickIngresarOfficeBanking();
    }

    @Step("Valido pantalla")
    public void validoPantalla() {
        loginPage.validoPantalla();
    }

    @Step("Selecccionar recordar tarjeta")
    public void seleccionarRecordar() {
        loginPage.checkRecordarTarjeta();
    }

    @Step("Escribir un alias")
    public void escribirAlias(String sAlias) {
        loginPage.ingresarAlias(sAlias);
    }

    @Step("Escribir el tipo de acceso")
    public void clickTipoAcceso(String tipo) {
        loginPage.clickTipoAcceso(tipo);
    }

    @Step("Clic en ingresar al boton de office banking")
    public void clickIngresarOfficeBanking() {
        loginPage.clickIngresarOfficeBanking();
    }

    @Step("Ingresar clave de internet")
    public void ingresarClaveInternet(String clave) {
        loginPage.ingresarClaveInternet(clave);
    }

    @Step("Ingresar tarjeta")
    public void ingresarTarjeta(String tarjeta) {
        loginPage.ingresarTarjeta(tarjeta);
    }

    @Step("Ingresar captcha")
    public void ingresarCaptcha(String captcha) {
        loginPage.ingresarCaptcha(captcha);
    }

    @Step("Conexion a BD")
    public void conectar_bd(String BD, String accion) throws Exception {
        /*if (BD.equalsIgnoreCase("PAUE-CERTIFICACION")) {
            BD = UtilsBD.DB2_BAUE_CERTIFICACION;
        }
        if (BD.equalsIgnoreCase("BD-CONTINUOUS")) {
            BD = UtilsBD.BD_CONTINUOUS_CERTIFICACION;
        }
        if (accion.equalsIgnoreCase("POST")) {
            accion = UtilsBD.INSERT;
        }
        if (accion.equalsIgnoreCase("GET")) {
            accion = UtilsBD.READ;
        }

        //saveVariableOnSession("query","INSERT INTO MSQLEU2NTLCDINT01.ntlc_automation.Integracion(TipoTarjeta, EstadoOperacion, Monedaoperacion, NumeroTarjeta, CodigoOperacion, MontoOperacion, Activo) VALUES(0, 0, 0, 'XNTLCI-123', 'D0001', 0, 1)");
        //saveVariableOnSession("query","SELECT CodigoOperacion AS CODIGOOPERACION FROM ntlc_automation.Integracion WHERE NumeroTarjeta='XNTLCI-123'");

        // Instanciar clase
        ConnectBD connect = new ConnectBD();
        // Crear estructura de respuesta
        connect.connectBD(
                getVariableOnSession("query"),
                environmentVariables,
                BD,
                accion);

        //System.out.println(getVariableOnSession("queryResult").toString());*/
    }

}
