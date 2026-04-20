pipeline {
    agent any
    
    // Add this section
    tools {
        maven 'Maven3' // Use the EXACT name you found in Step 1
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
            echo 'Build SUCCESS ✅'
        }
        failure {
            echo 'Build FAILED ❌'
        }
    }
}