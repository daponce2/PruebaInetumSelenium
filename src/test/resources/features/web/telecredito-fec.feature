#language: es

@REGRESION @REG_COMPRA_LOCAL
Característica: REGISTRO DE COMPRA LOCAL
  Como un usuario comun
  Quiero registrar una compra local
  Para Simular el financiamiento del pago de una compra local

  Antecedentes:
    Dado cargo la pagina de OfficeBanking en "chrome"

  @XFED-1167-1172-1174-1177-1179-1180-1186-1189-1190-1203-1214
  Esquema del escenario: Registro exitoso de compra local, SIN proveedores en lista blanca, cuentas de destino y de cargo invalidas
    Dado Que inicio el acceso <sTipoTarjeta> con mis datos personales <sNumeroTarjeta>
    Cuando Accedo a Financiamiento Electronico
    Y Registro una nueva compra local en moneda "<sMoneda>"
    Y Ingreso el ruc/dni <sRucDNI>, cuenta destino del proveedor <sCtaDestino> con su correo <sCorreo>
    Y Agrego el tipo de documento <sTipoDocumento>, numero <sNumDocumento> con el monto a pagar <sImporte>
    Y Confirmo datos de proveedor y documento
    Y Agrego los datos correspondientes para pago en cuotas con cuenta cargo <sCtaCargo>
      | sNumCuotas | sDiaDePagoCuotas | sPrimerDiaPago |
      | 2          | 1                | 5              |
    Y Confirmo el registro de la compra local
    Entonces Valido que se haya registrado la solicitud de financiamiento de compra local
    Y Guardo el codigo de operacion en la base de datos "<ID>"

    Ejemplos:
      | ID        | sTipoTarjeta       | sNumeroTarjeta | sMoneda | sRucDNI     | sCtaDestino   | sCorreo            | sTipoDocumento  | sNumDocumento | sImporte | sCtaCargo        | cListBlanca | sCondionCtaDestino | sCondicionCtaCargo |
      | XFED-1167 | Acceso Empresarial | 5001154510     | Soles   | 20306154339 | 1931507102052 | kakaroto@gmail.com | FACTURA         | 41217045      | 50       | 193-1507101-0-42 | SI          | ACTIVA             | ACTIVA             |
      | XFED-1172 | Acceso Empresarial | 5001154825     | Soles   | 20331530159 | 1921553780046 | kakaroto@gmail.com | FACTURA         | 41217045      | 50       | 193-1512271-0-64 | NO          | BLOQUEADA          | SIN SALDO          |