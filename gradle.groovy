
/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(){
  
  stage(){
    //Escribir directamente el código del stage, sin agregarle otra clausula de Jenkins.
  }

}

return this;

pipeline {
    agent any

    stages {
        stage('Build & Unit Test') {
            steps {
                script {
                    println "Stage: ${env.STAGE_NAME}"
                    }
                }
            }
        }
        stage('Sonar') {
            steps {
                script {
                    println "Stage: ${env.STAGE_NAME}"
                    }
                }
            }
        }
        stage('Run') {
            steps {
                script {
                    println "Stage: ${env.STAGE_NAME}"
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    println "Stage: ${env.STAGE_NAME}"
                    }
                }
            }
        }
	stage('Nexus') {
            steps {
                script {
                    println "Stage: ${env.STAGE_NAME}"
                    }
                }
            }
        }
    }
}

