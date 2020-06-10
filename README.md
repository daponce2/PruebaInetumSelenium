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


<h3>¿Cómo genero el reporte?</h3>
Para tomar evidencia en formato html, se deberá utlizar el siguiente metodo despues de cada interacción que se quiera
evidenciar.
> mvn clean verify -Dcucumber.options="--tags @TAG" -Dmainframe.user="XXXXX" -Dmainframe.password="XXXXX"

<h3>¿Dónde encuentro el reporte de las pantallas y de la ejecución?</h3>
Las evidencias de las pantallas en HTML se encontrarán ordenadas por fecha en la siguiente ruta:
> /report

El reporte total generado por serenity se encontrará en la siguiente ruta:
> /target/site/serenity

<h3>Comando para la ejecucion por terminal:</h3>
> mvn clean verify -Dcucumber.options="--tags @TAG" -Dmainframe.user="XXXXX" -Dmainframe.password="XXXXX"
* mainframe.user = Usuario con permisos para ingresar al core bancario.
* mainframe.password = Contrasena del usuario.
* @TAG = Tag a ejecutar declarado en el escenario del feature.

<h2>Dependencias</h2>
El framework tiene como unica dependencia el JAR <b>mainframe-continuous-testing</b> el cual será descargado
desde el artifactory de BCP, para esto la configuración de esta descarga se encuentra en el pom.xml

<h5>¿Qué hago si no descarga la dependenicia?</h5>
Cuando el jar no descarga directamente desde el artifactory de BCP, realizar los siguientes pasos de contingencia:

1.  Ir al artifactory y descargar directamente el jar <b>mainframe-continuous-testing</b>
    > https://artifactorydesa.lima.bcp.com.pe/artifactory/webapp/#/artifacts/browse/tree/General/INCT.Snapshot/com/everis/continuous-testing/mainframe-continuous-testing/1.0-SNAPSHOT
2.  Comentar la sección de configuración del artifactory en el pom.xml
    >   <repositories>
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
    >  </repositories>
      
3.  Copiar el jar <b>mainframe-continuous-testing</b> dentro del modulo de trabajo y "Agregar como Libreria".

<h2>Generar el javadoc</h2>
Para poder ver la documentación del framework a nivel de metodos, utilizar el comando:
> mvn javadoc:javadoc

La documentación generada en encontrá en la ruta
>/target/site/api-documents