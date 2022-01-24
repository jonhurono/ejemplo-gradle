/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(){
  
    stage('Compile') {
        sh "mvn clean compile -e"
    }
    
    stage('Test') {
        sh "mvn clean test -e"
    }

    stage('Jar') {
        sh "mvn clean package -e"
    }

    stage('SonarQube analysis') {
        def scannerHome = tool 'sonar-scanner';
        withSonarQubeEnv('sonar-server') {
            bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-maven -Dsonar.sources=src -Dsonar.java.binaries=build"
        }
    }
    
    stage('uploadNexus') {
        echo 'uploadNexus';
        nexusPublisher nexusInstanceId: 'nexus_test', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'C:/Users/jjcha/Documents/Diplomado/Repos/ejemplo-maven/build/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
    }
    
}


return this;