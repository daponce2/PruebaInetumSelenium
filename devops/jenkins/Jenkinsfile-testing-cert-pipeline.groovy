@Library('jenkins-sharedlib@master')
@Library('testing-jenkins-sharedlib-develop') 

import sharedlib.JenkinsfileUtil
import sharedlib.testing.MavenFunctionalTest

def recipients=''
def project = "INCT"
def environment = "cert" // ambientes: dev, cert
def slave = "pinctsop33-lnx-jenkins-slave"
//def slave = "pinctlnxp11-lnx-jenkins-slave"

def hashicorpEnabled = false // true para leer de vault, sino jenkins.

def utilsTesting = new MavenFunctionalTest(this)
def scenarios = "" 
def browserDriver = ""
def type = ""

try {
  node {

    stage("Preparation") {
      utilsTesting.notifyByMail('START',recipients)
      
      scenarios = params.TAGS 
      browserDriver = params.NAVEGADOR
      type = params.TIPO_DE_PRUEBA
            
      checkout scm
      
      utilsTesting.prepare(type,scenarios,browserDriver)
      
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
      utilsTesting.buildMaven() 
    }
    
    stage("Test") {      
      //Si es true, entonces toma las credenciales de la boveda para obtener el token al inicio de la prueba:
      // {project}-credential-client-id-dev
      // {project}-credential-client-secret-dev
      utilsTesting.setUseApiCredentials(false)
      
      utilsTesting.setBrowserDriver(browserDriver)
      
      utilsTesting.executeFunctionalTest(environment, scenarios, type) 
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
  
