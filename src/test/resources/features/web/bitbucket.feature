#language:es
@bitbucket
Característica: Validar mensajes de error Bitbucket

  Escenario: Validar mensaje de error a Bitbucket BCP
    Dado que abro la pagina del Bitbucket
    Cuando ingreso mis datos de usuario
    Entonces valido que el mensaje de error: "Invalid username or password."

