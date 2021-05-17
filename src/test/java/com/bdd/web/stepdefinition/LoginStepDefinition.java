package com.bdd.web.stepdefinition;

import com.bdd.web.step.LoginStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import web.com.bdd.util.UtilWeb;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import static web.com.bdd.util.UtilWeb.getVariableOnSession;
import static web.com.bdd.util.UtilWeb.saveVariableOnSession;

public class LoginStepDefinition {

    @Steps
    private LoginStep loginBcpSteps;

    private Scenario myScenario;
    private EnvironmentVariables environmentVariables;

//    @After
//    public void after(){
//        WebDriver driver = getVariableOnSession("driver");
//        driver.close();
//    }

    @Before()
    public void before(Scenario scenario) {
        saveVariableOnSession("scenario", scenario);
        myScenario = scenario;
    }

    @Dado("^que cargo la pagina de OfficeBanking en \"([^\"]*)\"$")
    public void cargar_pagina_officebanking(String browser) throws Throwable {
        loginBcpSteps.cargarPaginaOfficeBanking();
    }

    @Dado("^que estoy en la pagina de Office Banking$")
    public void estoy_en_pagina_de_office_banking() throws MalformedURLException {
        loginBcpSteps.cargarPaginaOfficeBanking();
    }

    @Y("^selecciono tarjeta valida \"([^\"]*)\" de tipo \"([^\"]*)\"$")
    public void selecciono_tarjeta_valida_de_tipo(String numTarjeta, String tipoAcceso) {
        Scenario scenario = getVariableOnSession("scenario");
        String reporte = "<style>\n" +
                "table { \n" +
                "\twidth: 750px; \n" +
                "\tborder-collapse: collapse; \n" +
                "\tmargin:50px auto;\n" +
                "\t}\n" +
                "\n" +
                "/* Zebra striping */\n" +
                "tr:nth-of-type(odd) { \n" +
                "\tbackground: #eee; \n" +
                "\t}\n" +
                "\n" +
                "th { \n" +
                "\tbackground: #3498db; \n" +
                "\tcolor: white; \n" +
                "\tfont-weight: bold; \n" +
                "\t}\n" +
                "\n" +
                "td, th { \n" +
                "\tpadding: 10px; \n" +
                "\tborder: 1px solid #ccc; \n" +
                "\ttext-align: left; \n" +
                "\tfont-size: 18px;\n" +
                "\t}\n" +
                "\n" +
                "/* \n" +
                "Max width before this PARTICULAR table gets nasty\n" +
                "This query will take effect for any screen smaller than 760px\n" +
                "and also iPads specifically.\n" +
                "*/\n" +
                "@media \n" +
                "only screen and (max-width: 760px),\n" +
                "(min-device-width: 768px) and (max-device-width: 1024px)  {\n" +
                "\n" +
                "\ttable { \n" +
                "\t  \twidth: 100%; \n" +
                "\t}\n" +
                "\n" +
                "\t/* Force table to not be like tables anymore */\n" +
                "\ttable, thead, tbody, th, td, tr { \n" +
                "\t\tdisplay: block; \n" +
                "\t}\n" +
                "\t\n" +
                "\t/* Hide table headers (but not display: none;, for accessibility) */\n" +
                "\tthead tr { \n" +
                "\t\tposition: absolute;\n" +
                "\t\ttop: -9999px;\n" +
                "\t\tleft: -9999px;\n" +
                "\t}\n" +
                "\t\n" +
                "\ttr { border: 1px solid #ccc; }\n" +
                "\t\n" +
                "\ttd { \n" +
                "\t\t/* Behave  like a \"row\" */\n" +
                "\t\tborder: none;\n" +
                "\t\tborder-bottom: 1px solid #eee; \n" +
                "\t\tposition: relative;\n" +
                "\t\tpadding-left: 50%; \n" +
                "\t}\n" +
                "\n" +
                "\ttd:before { \n" +
                "\t\t/* Now like a table header */\n" +
                "\t\tposition: absolute;\n" +
                "\t\t/* Top/left values mimic padding */\n" +
                "\t\ttop: 6px;\n" +
                "\t\tleft: 6px;\n" +
                "\t\twidth: 45%; \n" +
                "\t\tpadding-right: 10px; \n" +
                "\t\twhite-space: nowrap;\n" +
                "\t\t/* Label the data */\n" +
                "\t\tcontent: attr(data-column);\n" +
                "\n" +
                "\t\tcolor: #000;\n" +
                "\t\tfont-weight: bold;\n" +
                "\t}\n" +
                "\n" +
                "}"+
                "</style>" +
                "<table>\n" +
                "  <thead>\n" +
                "    <tr>\n" +
                "      <th>First Name</th>\n" +
                "      <th>Last Name</th>\n" +
                "      <th>Job Title</th>\n" +
                "      <th>Twitter</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td data-column=\"First Name\">James</td>\n" +
                "      <td data-column=\"Last Name\">Matman</td>\n" +
                "      <td data-column=\"Job Title\">Chief Sandwich Eater</td>\n" +
                "      <td data-column=\"Twitter\">@james</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td data-column=\"First Name\">Andor</td>\n" +
                "      <td data-column=\"Last Name\">Nagy</td>\n" +
                "      <td data-column=\"Job Title\">Designer</td>\n" +
                "      <td data-column=\"Twitter\">@andornagy</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td data-column=\"First Name\">Tamas</td>\n" +
                "      <td data-column=\"Last Name\">Biro</td>\n" +
                "      <td data-column=\"Job Title\">Game Tester</td>\n" +
                "      <td data-column=\"Twitter\">@tamas</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td data-column=\"First Name\">Zoli</td>\n" +
                "      <td data-column=\"Last Name\">Mastah</td>\n" +
                "      <td data-column=\"Job Title\">Developer</td>\n" +
                "      <td data-column=\"Twitter\">@zoli</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td data-column=\"First Name\">Szabi</td>\n" +
                "      <td data-column=\"Last Name\">Nagy</td>\n" +
                "      <td data-column=\"Job Title\">Chief Sandwich Eater</td>\n" +
                "      <td data-column=\"Twitter\">@szabi</td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>";
        byte[] byteX =  reporte.getBytes();
        scenario.attach(byteX,"text/html","evidencia");
        loginBcpSteps.seleccionarTipoAcceso(tipoAcceso);
        loginBcpSteps.escribirTarjeta(numTarjeta);
    }

    @Y("^accedo con clave de internet \"([^\"]*)\" y captcha \"([^\"]*)\" correctos$")
    public void trato_de_acceder_con_clave_y_captcha_correctos(String claveInternet, String captcha) {
        loginBcpSteps.escribirClaveInternet(claveInternet);
        loginBcpSteps.escribirCaptcha(captcha);
        loginBcpSteps.clickBotonIngresar();
    }

    @Cuando("^valido que me encuentre en el inicio$")
    public void valido_pantalla() {
        loginBcpSteps.validoPantalla();
    }

    @Y("^selecciono recordar tarjeta con alias \"([^\"]*)\"$")
    public void selecciono_recordar_tarjeta_con_alias(String sAlias) {
        loginBcpSteps.seleccionarRecordar();
        loginBcpSteps.escribirAlias(sAlias);
    }

    @Dado("^que inicio sesion con la tarjeta \"([^\"]*)\" de tipo \"([^\"]*)\" con clave \"([^\"]*)\" con captcha \"([^\"]*)\"$")
    public void iniciarSesionOfficeBanking(String sNumeroTarjeta, String sTipoTarjeta, String sClave, String sCaptcha) {
        loginBcpSteps.clickTipoAcceso(sTipoTarjeta);
        loginBcpSteps.ingresarTarjeta(sNumeroTarjeta);
        loginBcpSteps.ingresarClaveInternet(sClave);
        loginBcpSteps.ingresarCaptcha(sCaptcha);
        loginBcpSteps.clickIngresarOfficeBanking();
    }

    @Dado("^que ingreso las credenciales para iniciar sesion$")
    public void iniciar_sesion_officebanking(DataTable table) {
        List<Map<String, String>> list = table.asMaps(String.class, String.class);
        loginBcpSteps.clickTipoAcceso(list.get(0).get("sTipoTarjeta"));
        loginBcpSteps.ingresarTarjeta(list.get(0).get("sNumeroTarjeta"));
        loginBcpSteps.ingresarClaveInternet(list.get(0).get("sClave"));
        loginBcpSteps.ingresarCaptcha(list.get(0).get("sCaptcha"));
        loginBcpSteps.clickIngresarOfficeBanking();
    }

    @Y("^quiero conectar a base de datos de \"([^\"]*)\" con accion \"([^\"]*)\"$")
    public void conectar_bd(String BD, String accion) throws Exception {
        loginBcpSteps.conectar_bd(BD,accion);
    }

}
