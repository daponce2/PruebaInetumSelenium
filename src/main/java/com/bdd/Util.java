package com.bdd;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Util {

    private Util(){
        //Nothing TODO
    }

    /**
     * Obtener una propiedad o variables de ambinete
     *
     * @param environmentVariables Variables de ambiente del fichero serenity.properties
     * @param propiedad Nombre de la propiedad del fichero serenity.properties
     * @return el valor de la propiedad
     */
    public static String getContentEvironmentVariable(EnvironmentVariables environmentVariables, String propiedad) {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(propiedad);
    }


    /**
     * Obtener la fecha actual a partir de un formato especifico
     * @return la fecha formateada
     */
    public static String currentDateString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constants.FORMAT_DATE);
        return dtf.format(LocalDateTime.now());
    }

    /**
     * Obteniene caracter por caracter de una cadena de caracteres
     * @param value Cadena de caracteres
     * @return retorna un solo caracter de la cadena de caracteres
     */
    public static String getChartByChart(String value){
        String chart = StringUtils.EMPTY;
        for(int i = 0; i< value.length(); i++){
            chart = String.valueOf(value.charAt(i));
        }
        return chart;
    }

    public static String getIndiceSegunNumeroCuenta(String numeroCuenta){
        List<String> indice = Arrays.asList(numeroCuenta.split("-"));

        return indice.get(2);

    }

    /**
     * Toma evidencia de la pantalla actual
     *
     * @param scenario Clase Scenario de Cucumber
     * @param driver   driver en ejecucion
     */
    public static void takeScreenShotWeb(Scenario scenario, WebDriver driver) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }

    /**
     * Guardar una variable en sesion para utilizarla por escenario
     *
     * @param key   Nombre e indeficador de la variable a guardar
     * @param value Valor de la variale
     */
    public static void saveVariableOnSession(String key, Object value) {
        Serenity.setSessionVariable(key).to(value);
    }

    /**
     * Obtiene el valor de la variale guardada con el metodo saveVariableOnSession
     *
     * @param key Nombre e indeficador de la variable que se desea obtener
     * @return Valor de la variable buscada
     */
    public static <T> T getVariableOnSession(String key) {
        return Serenity.sessionVariableCalled(key);
    }

    public static void screenshot(WebDriver webDriver){
        System.out.println("SCREENSHOT");
        takeScreenShotWeb((Scenario) getVariableOnSession(Constants.SCENARIO), webDriver);
    }


}
