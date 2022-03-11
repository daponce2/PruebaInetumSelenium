@Library('jenkins-sharedlib@master')
//@Library('testing-jenkins-sharedlib-develop')//branch develop
@Library('testing-jenkins-sharedlib')//branch master

import sharedlib.JenkinsfileUtil
import sharedlib.testing.MavenFunctionalTest

def recipients=''
def project = "INCT"
def environment = "dev" // ambientes: dev, cert
def slave = "pinctsop33-lnx-jenkins-slave"
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

      utilsTesting.setHashicorpVaultEnabled(hashicorpEnabled)
      utilsTesting.setHashicorpVaultEnvironment(environment)

      utilsTesting.setTestEnvironment(environment)
      utilsTesting.setLinuxServerTest(slave)
      utilsTesting.setBuildEnvironment("dev")
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

      //opción disponible en proximo release del framework 1.1
      utilsTesting.setUseJiraCredentials(true)

      utilsTesting.executeFunctionalTest(scenarios, type)
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
