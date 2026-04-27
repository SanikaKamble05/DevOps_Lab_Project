pipeline {
    agent any
    
    tools {
        maven 'Maven3'
    }

    stages {
        stage('Clone Code') {
            steps {
                echo "Cloning done automatically"
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        success {
            echo 'Build SUCCESS'
        }
        failure {
            echo 'Build FAILED'
        }
    }
}