package com.bdd.web.stepdefinition;

import com.bdd.web.step.TlcnpSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;


public class TlcnpStepDefinition {

    @Steps
    private TlcnpSteps loginBcpSteps;

    @Given("^Cargar la pagina de TLCNp$")
    public void cargar_la_pagina_de_TLCNp() throws Exception {
        loginBcpSteps.cargarPaginaTLCNp();
    }

    @And("^Ingreso tarjeta \"([^\"]*)\" con \"([^\"]*)\"$")
    public void escribitar_Tarjeta(String numero, String clave) {
        loginBcpSteps.escribirTarjeta(numero, clave);
    }

    @When("^selecciono tipo de tarjeta \"([^\"]*)\"$")
    public void selecciono_tipo_tarjeta(String tipo) {
        loginBcpSteps.seleccionoTipoTarjeta(tipo);
    }

    @When("^selecciono el numero de cuenta \"([^\"]*)\"$")
    public void selecciono_numero_cuenta(String num) {
        loginBcpSteps.selecciononumCuenta(num);
    }


    @Then("^Guardar numero de operacion \"([^\"]*)\" con \"([^\"]*)\"$")
    public void guardar_num_operacion(String num, String monto) throws IOException {
        loginBcpSteps.guardarNumeropOP(num, monto);
    }

    @Then("^Guardar numero de operacion \"([^\"]*)\" con \"([^\"]*)\" con \"([^\"]*)\"$")
    public void guardar_num_operacion_ccextran(String num, String monto, String cuentaDestino) throws IOException {
        loginBcpSteps.guardarNumeropOPExterno(num, monto, cuentaDestino);
    }

    @And("^doy clic a transferencias BCP con cuentas propias$")
    public void clic_trasnferenciasPropiasbcp() {
        loginBcpSteps.clicOperacionesMonetarias();
        loginBcpSteps.clicTrasnferencias();
        loginBcpSteps.cliccuentasBCP();
        loginBcpSteps.clicCuentasPropias();
    }

    @And("^doy clic a transferencias BCP con cuentas terceros$")
    public void clic_trasnferenciasterceros() {
        loginBcpSteps.clicOperacionesMonetarias();
        loginBcpSteps.clicTrasnferencias();
        loginBcpSteps.cliccuentasBCP();
        loginBcpSteps.clicCuentasTerceros();
    }

    @And("^envio a firma \"([^\"]*)\"$")
    public void envio_firma(String accion) {
        loginBcpSteps.enviarAFirmar(accion);
    }


    @And("^selecciono datos de la cuenta destino \"([^\"]*)\" con \"([^\"]*)\" con moneda en \"([^\"]*)\"$")
    public void selecciono_datos_cuenta_destino(String cuentaDestino, String monto, String moneda) {
        loginBcpSteps.seleccionoDatosCuentaDestino(cuentaDestino, monto, moneda);
        loginBcpSteps.clicbtnContinuar();

    }

    @And("^selecciono datos de la cuenta abono \"([^\"]*)\" con la misma moneda \"([^\"]*)\" con cuesta destino \"([^\"]*)\"$")
    public void selecciono_datos_cuenta_destino(String cuentaAbono, Boolean mismaMoneda, String cuentaDestino) {
        loginBcpSteps.seleccionarCuentaSegunFlag(cuentaAbono, mismaMoneda, cuentaDestino);

    }

    @And("^selecciono datos de la cuenta destino \"([^\"]*)\" con \"([^\"]*)\" en \"([^\"]*)\" con tipo \"([^\"]*)\" y \"([^\"]*)\"$")
    public void selecciono_datos_cuenta_destino_con_tipo(String cuentaDestino, String monto, String moneda, String tipo, Boolean mismaMoneda) {
        loginBcpSteps.seleccionoDatosCuentaDestinoTipo(cuentaDestino, monto, moneda, tipo, mismaMoneda);
        loginBcpSteps.clicbtnContinuar();

    }

}
