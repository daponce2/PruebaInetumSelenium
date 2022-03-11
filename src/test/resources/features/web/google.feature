#language:es
@Google
Característica: Abrir Google

  @DEMO_SELENIUM
  Escenario: Buscar cantantes de rock
    Dado que abro la pagina de Google
    Cuando realizo una busqueda "cantantes de rock"
    Entonces valido que el resultado de la busqueda sea: "19,900,000"

  @DEMO_SHADOWROOT
  Escenario: Buscar configuracion de Chrome con  SHADOWROOT
    Dado que abro la pagina de configuracion de Google
    Cuando busco la configuracion "Navegador predeterminado"
    Entonces valido que el resultado sea: "Navegador predeterminado"
    Y valido que el navegador sea: "Google Chrome"
