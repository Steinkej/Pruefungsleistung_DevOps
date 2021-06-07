pipeline {
    agent any
    stages {
        stage('Build') {
                 steps {
                       sh 'echo "Building.."'
                       sh 'chmod +x gradlew'
                       sh './gradlew build -x test'
                       }
                      }
        stage('Test') {
                 steps {
                        sh 'echo "Testing.."'
                        sh 'chmod +x gradlew'
                        sh './gradlew test'
                 }
        }
    }
}