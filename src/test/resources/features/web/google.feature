#language:es
Característica: Abrir Google

  @Google
  Escenario: Abrir Google
    Dado que abro la pagina de Google
    Cuando realizo una busqueda "hola"
    Entonces valido que el resultado de la busqueda sea "Cerca de 858,000,000 resultados"