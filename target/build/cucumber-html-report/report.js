$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/web/tlcnp.feature");
formatter.feature({
  "name": "Transferencias entre cuentas",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tlcnp"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Transferencia a cuentas propias BCP",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tlcnp1"
    }
  ]
});
formatter.step({
  "name": "selecciono tipo de tarjeta \"\u003csTipoTarjeta\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "Ingreso tarjeta \"\u003csTarjeta\u003e\" con \"\u003csClave\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "doy clic a transferencias BCP con cuentas propias",
  "keyword": "And "
});
formatter.step({
  "name": "selecciono el numero de cuenta \"\u003csCuenta\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "selecciono datos de la cuenta abono \"\u003csCuenta\u003e\" con la misma moneda \"\u003csMismaMoneda\u003e\" con cuesta destino \"\u003csCuentaDestino\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "selecciono datos de la cuenta destino \"\u003csCuentaDestino\u003e\" con \"\u003csMonto\u003e\" con moneda en \"\u003csMoneda\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "envio a firma \"\u003csAccion\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "Guardar numero de operacion \"\u003csTarjeta\u003e\" con \"\u003csMonto\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "sMonto",
        "sMoneda",
        "sCuentaDestino",
        "sCuenta",
        "sClave",
        "sTipoTarjeta",
        "sTarjeta",
        "sAccion",
        "sMismaMoneda"
      ]
    },
    {
      "cells": [
        "10",
        "US$",
        "193-1551734-0-79",
        "193-1550736-1-08",
        "111111",
        "Acceso Empresarial",
        "5001207417",
        "Enviar a firma",
        "true"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Cargar la pagina de TLCNp",
  "keyword": "Given "
});
formatter.match({
  "location": "tlcnpStepDefinition.cargar_la_pagina_de_TLCNp()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Transferencia a cuentas propias BCP",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tlcnp"
    },
    {
      "name": "@tlcnp1"
    }
  ]
});
formatter.step({
  "name": "selecciono tipo de tarjeta \"Acceso Empresarial\"",
  "keyword": "When "
});
formatter.match({
  "location": "tlcnpStepDefinition.selecciono_tipo_tarjeta(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Ingreso tarjeta \"5001207417\" con \"111111\"",
  "keyword": "And "
});
formatter.match({
  "location": "tlcnpStepDefinition.escribitar_Tarjeta(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "doy clic a transferencias BCP con cuentas propias",
  "keyword": "And "
});
formatter.match({
  "location": "tlcnpStepDefinition.clic_trasnferenciasPropiasbcp()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selecciono el numero de cuenta \"193-1550736-1-08\"",
  "keyword": "And "
});
formatter.match({
  "location": "tlcnpStepDefinition.selecciono_numero_cuenta(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selecciono datos de la cuenta abono \"193-1550736-1-08\" con la misma moneda \"true\" con cuesta destino \"193-1551734-0-79\"",
  "keyword": "And "
});
formatter.match({
  "location": "tlcnpStepDefinition.selecciono_datos_cuenta_destino(String,Boolean,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selecciono datos de la cuenta destino \"193-1551734-0-79\" con \"10\" con moneda en \"US$\"",
  "keyword": "And "
});
formatter.match({
  "location": "tlcnpStepDefinition.selecciono_datos_cuenta_destino(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "envio a firma \"Enviar a firma\"",
  "keyword": "And "
});
formatter.match({
  "location": "tlcnpStepDefinition.envio_firma(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Guardar numero de operacion \"5001207417\" con \"10\"",
  "keyword": "And "
});
formatter.match({
  "location": "tlcnpStepDefinition.guardar_num_operacion(String,String)"
});
formatter.result({
  "status": "passed"
});
});