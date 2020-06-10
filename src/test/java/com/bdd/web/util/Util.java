package com.bdd.web.util;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static String getTipoMonedaSegunNumeroCuenta(String numeroCuenta){
        numeroCuenta = "1931550724-0-77";
        numeroCuenta = numeroCuenta.replace("-","");
        if(numeroCuenta.length() == 13){
            String indicador = numeroCuenta.substring(10,11);

            if(indicador.equals(1))
                return "dolares";
            if(indicador.equals(0))
                return "soles";
        }
        return "error";

    }
    public static String getIndiceSegunNumeroCuenta(String numeroCuenta){
        List<String> indice = Arrays.asList(numeroCuenta.split("-"));

        return indice.get(2);

    }
}
