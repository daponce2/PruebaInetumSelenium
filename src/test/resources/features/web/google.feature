#language:es
@Google
Característica: Abrir Google

  Escenario: Buscar cantantes de rock
    Dado que abro la pagina de Google
    Cuando realizo una busqueda "cantantes de rock"
    Entonces valido que el resultado de la busqueda sea "19,900,000"