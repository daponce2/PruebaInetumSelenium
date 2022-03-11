@Library('jenkins-sharedlib@master')
@Library('testing-sharedlib@feature/pipeline-api-web') // FIXME: cambiar a dev after merge
import sharedlib.JenkinsfileUtil
import sharedlib.testing.MavenFunctionalTest

def recipients=''
def project = "INCT"
def environment = "dev" // ambientes: dev, cert
def slave = "pinctsop33-lnx-jenkins-slave"
//def slave = "pinctlnxp11-lnx-jenkins-slave"

def hashicorpEnabled = false // true para leer de vault, sino jenkins.
def remoteHub = "" // url remote location. Si es vacio se ejecuta en contenedor.

def utilsTesting = new MavenFunctionalTest(this)

try {
  node {

    stage("Preparation") {
      utilsTesting.notifyByMail('START',recipients)
      checkout scm
      utilsTesting.prepare()
      env.project = project
      
      //Variables para obtener credenciales desde HV
      utilsTesting.setHashicorpVaultEnabled(hashicorpEnabled) 
      utilsTesting.setHashicorpVaultEnvironment(environment)    
      
      //entorno donde se ejecutan las pruebas
      utilsTesting.setTestEnvironment(environment)
      
      //Nodo donde se ejecutan las pruebas
      utilsTesting.setLinuxServerTest(slave)
    }

    stage("Build") {
      utilsTesting.build() 
    }

    stage("Test") {
      def scenarios = params.TAGS  
      def browserDriver = params.DRIVER
      def useJiraCredentials = params.USE_JIRA_CREDENTIALS
      def useApiCredentials = params.USE_API_CREDENTIALS

      utilsTesting.executeWebFunctionalTest(environment, scenarios, browserDriver, useJiraCredentials, useApiCredentials,remoteHub) 
    }

    stage("Post Execution") {
      utilsTesting.executePostExecutionTasks() 
      utilsTesting.notifyByMail('SUCCESS',recipients)
    }

  }
} catch(Exception e) {
  node{
    utilsTesting.executeOnErrorExecutionTasks()
    utilsTesting.notifyByMail('FAIL',recipients)
    throw e
  }
}
  
