@Library('jenkins-sharedlib@feature/continuous-testing')
@Library('testing-sharedlib@feature/testing')

import sharedlib.testing.MavenFunctionalTest

def utilsTesting = new MavenFunctionalTest(this)

def recipients = ''
def project = "INCT"

try {
    node {
        stage('Preparation') {
            //utils.notifyByMail('START',recipients)
            checkout scm
            utilsTesting.prepare()
            env.project = "${project}"
        }

        stage('Build') {
            utilsTesting.build()
        }

        stage('Test') {
            utilsTesting.executeWebFunctionalTest(params.Environment, params.TAGS)
        }

        stage('Post Execution') {
            utilsTesting.executePostExecutionTasks()
            //utils.notifyByMail('SUCCESS',recipients)
        }

    }
} catch (Exception e) {
    node {
        utilsTesting.executeOnErrorExecutionTasks()
        //utils.notifyByMail('FAIL',recipients)
        throw e
    }
}