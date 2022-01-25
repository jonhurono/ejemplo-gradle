pipeline {
    agent any
    
    environment {
	    STAGE = ''
	}

    parameters{
            choice choices: ['gradle', 'maven'], description: 'Indicar la herramienta de construccion', name: 'buildTool'
    }

    stages {
        stage('Pipeline') {
            steps {
                script {
                    try {
                        println "Pipeline"
                    
                        if (params.buildTool ==  "gradle") {
                            def ejecucion = load 'gradle.groovy'
	                        ejecucion.call()
                        } else {
                            def ejecucion = load 'maven.groovy'
	                        ejecucion.call()
                        }
                    
                    slackSend color: 'good', message: "Build Success: [${env.BUILD_USER}] [${env.JOB_NAME}] [${params.buildTool}] Ejecucion exitosa!! (Revisar en el siguiente link: ${env.BUILD_URL})"

                    }
                    catch (Exception e){
					    slackSend color: 'danger', message: "Build Failure: [${env.BUILD_USER}] [${env.JOB_NAME}] [${params.buildTool}][Ejecucion fallida en stage ${STAGE} (Revisar en el siguiente link: ${env.BUILD_URL})"
					    error "Ejecucion fallida en stage ${STAGE}"
					}
                }
            }
        }
    }
}