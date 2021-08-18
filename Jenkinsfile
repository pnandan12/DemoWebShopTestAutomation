pipeline {
    agent any

    stages {
        stage('Compile Stage') {
            steps {
              withMaven(maven:'MAVEN_HOME'){
              sh 'mvn clean compile'
              echo 'Compiling..'
              }
            }
        }
        stage('Testing Stage') {
            steps {
               withMaven(maven:'MAVEN_HOME'){
              sh 'mvn test'
                echo 'Testing..'
               }
            }
        }
        stage('Deployment Stage') {
            steps {
               withMaven(maven:'MAVEN_HOME'){
                sh 'mvn deploy'
                echo 'Deploying....'
               }
            }
        }
    }
}
