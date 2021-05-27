@Library('jenkins-sharedlib@master')
@Library('testing-sharedlib@feature/refactor-integration-web-api') // change later for develop
import sharedlib.JenkinsfileUtil
import sharedlib.testing.MavenFunctionalTest

def recipients=''
def utilsTesting = new MavenFunctionalTest(this)
def project = "INCT"

try {
  node {

    stage("Preparation") {
      utilsTesting.notifyByMail('START',recipients)
      checkout scm
      utilsTesting.prepare()
      env.project = project
      utilsTesting.setHashicorpVaultEnabled(false)
      utilsTesting.setHashicorpVaultEnvironment("dev")
      utilsTesting.setBuildEnvironment("dev")
      utilsTesting.setTestEnvironment("dev")
      utilsTesting.setLinuxServerTest("pinctlnxp11-lnx-jenkins-slave")
    }

    stage("Build") {
      utilsTesting.build()
    }

    stage("Test") {
      def scenarios = params.TAGS
      def environment = "desa"
      def browserDriver = params.DRIVER
      def extraArgs = "-Djxray.update.evidence=false"
      def useJiraCredentials = params.USE_JIRA_CREDENTIALS
      def useApiCredentials = params.USE_API_CREDENTIALS

      utilsTesting.executeWebFunctionalTest(environment, scenarios, browserDriver, extraArgs, useJiraCredentials, useApiCredentials)
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
  