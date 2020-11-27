@DEMO
Feature: Transferencias entre cuentas

  Background:
    Given Cargar la pagina de TLCNp

  @DEMO01
  Scenario Outline: Transferencia a cuentas propias BCP
    When selecciono tipo de tarjeta "<sTipoTarjeta>"
    And Ingreso tarjeta "<sTarjeta>" con "<sClave>"
#    And doy clic a transferencias BCP con cuentas propias
#    And selecciono el numero de cuenta "<sCuenta>"
#    And selecciono datos de la cuenta abono "<sCuenta>" con la misma moneda "<sMismaMoneda>" con cuesta destino "<sCuentaDestino>"
#    And selecciono datos de la cuenta destino "<sCuentaDestino>" con "<sMonto>" con moneda en "<sMoneda>"
#    And envio a firma "<sAccion>"
#    And Guardar numero de operacion "<sTarjeta>" con "<sMonto>"
    Examples:
      | sMonto | sMoneda | sCuentaDestino   | sCuenta          | sClave | sTipoTarjeta       | sTarjeta   | sAccion        | sMismaMoneda |
      | 10     | US$     | 193-1551734-0-79 | 193-1550736-1-08 | 111111 | Acceso Empresarial | 5001207417 | Enviar a firma | true         |
