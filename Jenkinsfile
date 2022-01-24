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
                        def ejecucion = load 'gradle.groovy'
	                    ejecucion.call()
                    } else {
                        def ejecucion = load 'maven.groovy'
	                    ejecucion.call()
                    }

                }
            }
        }
    }

    post {
       // only triggered when blue or green sign
       success {
           slackSend ("Build Success: [John Chaves][${env.JOB_NAME}][buildTool] Ejecución exitosa.")

       }
       // triggered when red sign
       failure {
           slackSend ("Build Failed: [John Chaves][${env.JOB_NAME}][buildTool] Ejecución fallida.")

       }
       // trigger every-works
       always {
           slackSend ("Job finalizado.")
       }
    }
}