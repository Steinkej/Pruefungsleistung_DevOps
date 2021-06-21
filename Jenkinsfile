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
        stage('Javadoc') {
                  steps {
                         sh 'echo "Generating Javadoc..."'
                         sh 'chmod +x gradlew'
                         sh './gradlew javadoc'
                  }
        }
        stage('Zipping') {
                          steps {
                                 sh 'echo "Zipping javadoc, .jar, SourceCode.."'
                                 sh 'chmod +x gradlew'
                                 sh './gradlew Zipping'
                          }
                }
    }
}