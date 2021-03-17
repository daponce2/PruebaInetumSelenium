#language: es
#@INCTCT-12
@REGRESION_GOOGLE
Característica: REGRESION TEST GOOGLE V3

  @INCTCT-11 @INCTCT-13
  Escenario: Busqueda Google
    Dado que abro la pagina de Google
    Cuando realizo una busqueda "cantantes de rock"
    Entonces valido que el resultado de la busqueda sea "19,700,000"

  @INCTCT-17 @INCTCT-13
  Escenario: Busqueda Google v2
    Dado que abro la pagina de Google
    Cuando realizo una busqueda "cantantes de rock"
    Entonces valido que el resultado de la busqueda sea "19,700,000"