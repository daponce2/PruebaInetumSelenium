pipeline {
    agent any
    stages {
        stage('SCM'){
            steps {
                println('*** CHECK OUT CODE FROM GIT REPO ***')
                checkout scm
                println('*** CHECK OUT CODE FROM GIT REPO COMPLETED ***')
            }
        }
        stage('BUILD & TEST') {
            steps {
                script {
                    try{
                        println('*** TRIGGER BUILD & TEST ***')
                        sh "mvn clean verify  -Dcucumber.options=\"--tags ${params.TAGS}\""
                    } finally{
                        step([
                                $class: 'CucumberReportPublisher',
                                failedFeaturesNumber: 0,
                                failedScenariosNumber: 0,
                                failedStepsNumber: 0,
                                fileExcludePattern: '',
                                fileIncludePattern: '**/*.json',
                                jsonReportDirectory: 'target/build',
                                parallelTesting: true,
                                pendingStepsNumber: 0,
                                skippedStepsNumber: 0,
                                trendsLimit: 0,
                                undefinedStepsNumber: 0
                        ])
                    }
                }
            }
        }
    }
    post {
        always {
            script{
                //sendEmail("${RECIPIENTS}", currentBuild.fullDisplayName)
                deleteDir()
            }
        }
    }
}
