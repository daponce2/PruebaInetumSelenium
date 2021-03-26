package com.bdd;

import io.cucumber.java.Scenario;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import web.com.bdd.util.UtilWeb;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Util {

    private Util() {
        //Nothing TODO
    }

    /**
     * Obtener una propiedad o variables de ambinete
     *
     * @param environmentVariables Variables de ambiente del fichero serenity.properties
     * @param propiedad            Nombre de la propiedad del fichero serenity.properties
     * @return el valor de la propiedad
     */
    public static String getContentEvironmentVariable(EnvironmentVariables environmentVariables, String propiedad) {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(propiedad);
    }


    /**
     * Obtener la fecha actual a partir de un formato especifico
     *
     * @return la fecha formateada
     */
    public static String currentDateString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constants.FORMAT_DATE);
        return dtf.format(LocalDateTime.now());
    }

    /**
     * Obteniene caracter por caracter de una cadena de caracteres
     *
     * @param value Cadena de caracteres
     * @return retorna un solo caracter de la cadena de caracteres
     */
    public static String getChartByChart(String value) {
        String chart = StringUtils.EMPTY;
        for (int i = 0; i < value.length(); i++) {
            chart = String.valueOf(value.charAt(i));
        }
        return chart;
    }

    public static String getIndiceSegunNumeroCuenta(String numeroCuenta) {
        List<String> indice = Arrays.asList(numeroCuenta.split("-"));

        return indice.get(2);

    }

    public static void screenshot(WebDriver webDriver) {
        UtilWeb.takeScreenShotWeb((Scenario) UtilWeb.getVariableOnSession(Constants.SCENARIO), webDriver);
    }


}
