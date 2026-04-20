pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Run') {
            steps {
                bat 'mvn exec:java -Dexec.mainClass="AddTask"'
            }
        }
    }
}