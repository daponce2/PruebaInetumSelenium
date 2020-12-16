#!/opt/groovy/bin/groovy
/*****************************************************/


pipeline {

    agent any

    parameters {
        string(defaultValue: '@DEMO01', description: 'Tags para las pruebas. Ejemplo: @GENERAR_TOKEN', name: 'TAGS')
        //choice(name: 'Ejecucion', choices: ['Local','Remoto'], description:'Remoto es ejecución en el servidor')
    }

    stages {
        stage('checkout') {
            steps {
                sh 'ls'
         }
        }
    }
}
