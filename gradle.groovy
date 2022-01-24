/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(){
  
    stage('Build & Unit Test') {
        sh 'env'
        println "Stage: ${env.STAGE_NAME}"
        sh './gradlew clean build'
    }

    stage('Sonar') {
        println "Stage: ${env.STAGE_NAME}"
    }

    stage('Run') {
        println "Stage: ${env.STAGE_NAME}"
    }

    stage('Test') {
        println "Stage: ${env.STAGE_NAME}"
        }

	stage('Nexus') {
        println "Stage: ${env.STAGE_NAME}"
    }
    
}

return this;