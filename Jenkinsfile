pipeline {
    agent any

    stages {
        stage('Build Stage') {
            steps {
              withMaven(maven:'MAVEN_HOME'){
              bat 'mvn clean'
              }
            }
        }
        stage('Testing Stage') {
            steps {
               withMaven(maven:'MAVEN_HOME'){
                bat 'mvn test'
               }
            }
        }
        stage('Compile Stage') {
            steps {
               withMaven(maven:'MAVEN_HOME'){
                //sh 'mvn deploy'
                bat 'mvn compile'
               }
            }
        }
    stage('Deploy Stage'){
        steps{
            echo "deployment successfully..."
        }
    }
    }
}
