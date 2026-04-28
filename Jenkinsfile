pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo '>>> Checking out delete-task-feature branch'
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/delete-task-feature']],
                    userRemoteConfigs: [[
                        url: 'https://github.com/SanikaKamble05/DevOps_Lab_Project.git'
                    ]]
                ])
            }
        }

        stage('Build') {
            steps {
                echo '>>> Compiling Java source with Maven'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo '>>> Running tests'
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
                success {
                    echo '>>> All tests passed!'
                }
                failure {
                    echo '>>> Tests failed.'
                }
            }
        }

        stage('Package') {
            steps {
                echo '>>> Packaging application as JAR'
                bat 'mvn package -DskipTests'
            }
        }

        stage('Run Python App') {
            steps {
                echo '>>> Starting Python app'
                bat 'start python app.py'
            }
        }

        stage('Open Browser') {
            steps {
                bat 'timeout 5 && start http://localhost:5000'
            }
        }
    }

    post {
        success {
            echo "Pipeline SUCCESS — build #${env.BUILD_NUMBER} completed."
        }
        failure {
            echo "Pipeline FAILED — check logs."
        }
    }
}