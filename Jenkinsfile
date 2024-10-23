pipeline {
    agent any
    tools {
        maven 'MyMaven' // Use the name you provided in Global Tool Configuration
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test' // This will now reference the correct Maven installation
            }
        }
    }
}
