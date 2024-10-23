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

        stage('Build') {
            steps {
                // Clean and build the project using Maven
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test' // This will now reference the correct Maven installation
            }
        }
    }
}
