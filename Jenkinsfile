pipeline {
    agent any
    
    tools {
        // This must match the 'Name' you gave Maven in Step 1
        maven 'Maven3' 
    }

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
                bat 'mvn clean compile exec:java -Dexec.mainClass="AddTask"' 
            }
        }
    }
}