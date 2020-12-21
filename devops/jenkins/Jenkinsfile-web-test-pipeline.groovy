@Library('jenkins-sharedlib@feature/continuous-testing')
@Library('testing-sharedlib@feature/testing')

import sharedlib.testing.MavenFunctionalTest
import sharedlib.JenkinsfileUtil

def utilsTesting = new MavenFunctionalTest(this)
def utils = new JenkinsfileUtil(steps, this)

def recipients = ''
def project = "INCT"

try {
    node('pinctlnxp12-lnx-jenkins-slave') {
        stage('Preparation') {
            //utils.notifyByMail('START',recipients)
            checkout scm
            utils.prepare()
            env.project = "${project}"
        }

        stage('Build') {
            utils.buildMaven()
        }

        stage('Test') {
            utilsTesting.executeWebFunctionalTest('', params.Environment, params.TAGS)
        }

        stage('Post Execution') {
            utils.executePostExecutionTasks()
            //utils.notifyByMail('SUCCESS',recipients)
        }

    }
} catch (Exception e) {
    node {
        utils.executeOnErrorExecutionTasks()
        //utils.notifyByMail('FAIL',recipients)
        throw e
    }
}