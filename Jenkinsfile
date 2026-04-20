pipeline {
    agent any

    stages {
        stage('Clone Code') {
            steps {
                echo "Cloning done automatically"
            }
        }

        stage('Build') {
            steps {
                // This compiles your code using Maven
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                // Since there is no main method, we run the tests to show output
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