# Getting Started

### Build Code
* ./gradlew clean build
* gradle build


### Run Jar
* Local:      ./gradlew bootRun 
* gradle bootRun
* Pipeline:   nohup bash gradlew bootRun &

### Testing Application
* curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=testing'
