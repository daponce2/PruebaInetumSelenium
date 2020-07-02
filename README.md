<h1>Continuous Testing - Web</h1>

Este script permitira simular la acción humana a travéz de 
lineas de comandos enviados por metodos públicos dentro del 
framework para interactuar con los componentes web de un aplicativo.

<h3>Pre-requisito para el desarrollo</h3>
Para poder interactuar con el framework es necesario primero entender los flujos o escenarios que se van a automatizar
(Pantallas, procesos, arquitectura, etc). 

<h3>¿Cómo accedo a los metodos del framework?</h3>
Para acceder a los metodos del framework, la clase Page debe extender de la clase:
> BaseWebPage


<h3>¿Cómo ejecuto el proyecto?</h3>
> mvn clean verify -Dcucumber.options="--tags @TAG"


El reporte total generado por serenity se encontrará en la siguiente ruta:
> /target/site/serenity

<h2>Dependencias<h2>
El framework tiene como unica dependencia el JAR <b>api-continuous-testing</b> el cual será descargado
desde el artifactory de BCP, para esto la configuración de esta descarga se encuentra en el pom.xml

<h5>¿Qué hago si no descarga la dependenicia?</h5>
Cuando el jar no descarga directamente desde el artifactory de BCP, realizar los siguientes pasos de contingencia:

1.-  Ir al artifactory y descargar directamente el jar <b>web-continuous-testing</b>

```    
https://artifactorydesa.lima.bcp.com.pe/artifactory/webapp/#/artifacts/browse/tree/General/INCT.Snapshot/com/everis/continuous-testing/mainframe-continuous-testing/1.0-SNAPSHOT
```

2.-  Comentar la sección de configuración del artifactory en el pom.xml
 ```  
     <repositories>
            <repository>
                <snapshots>
                    <enabled>false</enabled>
                </snapshots>
                <id>central</id>
                <name>public</name>
                <url>http://10.79.6.36:8081/artifactory/public</url>
            </repository>
            <repository>
                <id>snapshots</id>
                <name>public.snapshots</name>
                <url>http://10.79.6.36:8081/artifactory/public.snapshots</url>
        </repository>
  </repositories>
```
      
3.-  Copiar el jar <b>api-continuous-testing</b> dentro del modulo de trabajo y "Agregar como Libreria".

4.- Ejecutar los comandos:
    
    $mvn org.apache.maven.plugins:maven-install-plugin:3.0.0-M1:install-file -Dfile=<path-jar>
    $mvn intall -DskipTests
    
    Volver a reimportar las dependencias