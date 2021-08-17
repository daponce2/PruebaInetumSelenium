<h1>Continuous Testing - Web</h1>

Este script permitira simular la acción humana a travéz de lineas de comandos enviados por metodos públicos dentro del
framework para interactuar con los componentes web de un aplicativo.

<h3>Pre-requisito para el desarrollo</h3>
Para poder interactuar con el framework es necesario primero entender los flujos o escenarios que se van a automatizar
(Pantallas, procesos, arquitectura, etc).

<h3>¿Cómo accedo a los metodos del framework?</h3>
Para acceder a los metodos del framework, la clase Page debe extender de la clase:
> BaseWebPage

<h3>Método con el que se inicializa el driver</h3>

```
private EnvironmentVariables environmentVariables;

    @Step("Cargar pagina de TLCNP")
    public void cargarPaginaTLCNp() throws MalformedURLException {
        loginPage.setDriver(WebDriverManager.setWebDriver(environmentVariables));
        loginPage.open();
        loginPage.getDriver().manage().window().maximize();
    }
```

<h3>Propiedades necesarias para la ejecución</h3>
Estas propiedades son necesarias para la ejecución del Test.

```
web.remote.hub=http://10.79.6.29:4444/wd/hub //host remoto
web.custom.browserName=chrome  //chrome, ie
web.browserName.headless=true  // false, true
```

<h3>¿Cómo ejecuto el proyecto?</h3>
> clean verify -Dcucumber.filter.tags=@Google -Denvironment=desarrollo


El reporte total generado por serenity se encontrará en la siguiente ruta:
> /target/site/serenity

<h2>Dependencias</h2>
El framework tiene como unica dependencia el JAR <b>web-continuous-testing</b> el cual será descargado desde el
artifactory de BCP, para esto la configuración de esta descarga se encuentra en el pom.xml

<h5>ARTIFACTORY DESARROLLO</h5>
Agregar el siguiente bloque en el pom.xml para descargar desde el artifactory de Desarrollo

```  
 <repositories>
         <repository>
             <snapshots>
                 <enabled>false</enabled>
             </snapshots>
             <id>central</id>
             <name>public</name>
             <url>https://artifactorydesa.lima.bcp.com.pe/artifactory/public</url>
         </repository>
         <repository>
             <snapshots />
             <id>snapshots</id>
             <name>public.snapshots</name>
             <url>https://artifactorydesa.lima.bcp.com.pe/artifactory/public.snapshots</url>
         </repository>
     </repositories>
     <pluginRepositories>
         <pluginRepository>
             <snapshots>
                 <enabled>false</enabled>
             </snapshots>
             <id>central</id>
             <name>public</name>
             <url>https://artifactorydesa.lima.bcp.com.pe/artifactory/public</url>
         </pluginRepository>
         <pluginRepository>
             <snapshots />
             <id>snapshots</id>
             <name>public.snapshots</name>
             <url>https://artifactorydesa.lima.bcp.com.pe/artifactory/public.snapshots</url>
         </pluginRepository>
     </pluginRepositories>
```

<h5>ARTIFACTORY PRODUCCIÓN</h5>
Agregar el siguiente bloque en el pom.xml para descargar desde el artifactory de Producción

```  
<repositories>
        <repository>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
          <id>central</id>
          <name>public</name>
          <url>https://artifactory.lima.bcp.com.pe/artifactory/public</url>
        </repository>
        <repository>
          <snapshots />
          <id>snapshots</id>
          <name>public.snapshot</name>
          <url>https://artifactory.lima.bcp.com.pe/artifactory/public.snapshot</url>
        </repository>
      </repositories>
      <pluginRepositories>
        <pluginRepository>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
          <id>central</id>
          <name>public</name>
          <url>https://artifactory.lima.bcp.com.pe/artifactory/public</url>
        </pluginRepository>
        <pluginRepository>
          <snapshots />
          <id>snapshots</id>
          <name>public.snapshot</name>
          <url>https://artifactory.lima.bcp.com.pe/artifactory/public.snapshot</url>
        </pluginRepository>
      </pluginRepositories>
```

Ejecutar los comandos:

    * $mvn intall -DskipTests
    * Volver a reimportar las dependencias   

## Integración con JXRAY

Agregar el siguiente código para actualizar el estado de los Test en el TestExecution de Jxray

Configuracion serenity.properties (true|false)

``` 
    jxray.update.evidence=false
``` 

En la clase RunnerTest, AfterClass llamar al metodo importTestResultExecution de la clase
JXrayServiceDom ubicada en el jar dependencia

```  java
    public class RunnerTest{
    
    @BeforeClass
    public static void beforeExecution() {
        UtilWeb.logger(RunnerTest.class).info("BEFORE >>>");
        setEnvironment(SystemEnvironmentVariables.createEnvironmentVariables());
    }
    
    @AfterClass
    public static void afterExecution() {
        UtilWeb.logger(RunnerTest.class).info("AFTER >>>");

        if (WebDriverManager.getWebDriver() != null)
            WebDriverManager.stopWebDriver();

        String cucumberJsonPath = System.getProperty("user.dir") + "/target/build/cucumber.json";
        boolean isJiraOn = UtilWeb.getBooleanEvironmentProperty(getEnvironment(), JXrayProperties.JXRAY_EVIDENCE);

        if (isJiraOn) {
            UtilWeb.logger(RunnerTest.class).log(Level.INFO, "Actualizar resultados en JiraXray: {0}", isJiraOn);
            JXrayServiceDom jXrayServiceDom = new JXrayServiceDom();
            Response response = jXrayServiceDom.importTestResultExecution(
                    new JXrayHelperCredentials(getEnvironment()).getJiraHost(),
                    cucumberJsonPath,
                    new JXrayHelperCredentials(getEnvironment()).getJXrayUser(),
                    new JXrayHelperCredentials(getEnvironment()).getJXrayPassword());
            response.then().assertThat().statusCode(200);

        } else {
            UtilWeb.logger(RunnerTest.class).log(Level.INFO, "Actualizar resultados en JiraXray: {0}", isJiraOn);
        }

    }
    }
```

### Ejecución JIRA XRAY - actualizar Test en TestExecution

```  
    -Djxray.update.evidence=true
```