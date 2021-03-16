#language: es
@INCTCT-12
Característica: REGRESION TEST GOOGLE

  @INCTCT-11 @INCTCT-13
  Escenario: Busqueda Google
    Dado que abro la pagina de Google
    Cuando realizo una busqueda "cantantes de rock"
    Entonces valido que el resultado de la busqueda sea "19,900,000"