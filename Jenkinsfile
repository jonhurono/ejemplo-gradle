pipeline {
    agent any
    
    environment {
	    STAGE = ''
	}

    parameters{
            choice choices: ['gradle', 'maven'], description: 'Indicar la herramienta de construcciÃƒÂ³n', name: 'buildTool'
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
                    
                    slackSend color: 'good', message: "Build Success: [John Chaves]['${env.JOB_NAME}'] ['${env.BUILD_NUMBER}'] Ejecución exitosa!'! (${env.BUILD_URL})"

                    }
                    catch (Exception e){
					    slackSend color: 'danger', message: "Build Failure: [John Chaves]['${env.JOB_NAME}'] ['${env.BUILD_NUMBER}'][Ejecución fallida en stage ${STAGE} (${env.BUILD_URL})"
					    error "Ejecución fallida en stage ${STAGE}"
					}
                }
            }
        }
    }
}