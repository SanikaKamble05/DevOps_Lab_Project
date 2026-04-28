pipeline {

```
agent any

stages {

    // ── 1. Checkout ────────────────────────────────────────────────────────
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

    // ── 2. Build ───────────────────────────────────────────────────────────
    stage('Build') {
        steps {
            echo '>>> Compiling Java source with Maven'
            sh 'mvn clean compile'
        }
    }

    // ── 3. Test ────────────────────────────────────────────────────────────
    stage('Test') {
        steps {
            echo '>>> Running tests'
            sh 'mvn test'
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

    // ── 4. Package ─────────────────────────────────────────────────────────
    stage('Package') {
        steps {
            echo '>>> Packaging application as JAR'
            sh 'mvn package -DskipTests'
        }
    }

    // - 5. run python script to deploy the application on local machine
    stage('Run Python App') {
            steps {
                bat 'start python app.py'
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
```

}
