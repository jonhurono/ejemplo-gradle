pipeline {
    agent any

    parameters{
            choice choices: ['gradle', 'maven'], description: 'Indicar la herramienta de construcciÃ³n', name: 'buildTool'
    }

    stages {
        stage('Pipeline') {
            steps {
                script {
                    println "Pipeline"
                    
                    if (params.buildTool ==  "gradle") {
                        println 'Ejecutar gradle'
                    } else {
                        println 'Ejecutar maven'
                    }

                }
            }
        }
    }
}