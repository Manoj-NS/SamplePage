pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from Git
                checkout scm
            }
        }
    //    stage('Build') {
    //        steps {
    //            // Clean and build the project using Maven
    //            sh 'mvn clean install'
    //        }
    //    }
    
        stage('Test') {
            steps {
                // Run tests
                bat 'mvn test'
            }
        }
        
      //  stage('Deploy') {
       //     steps {
                // For example, copying files to a remote server
       //         sh 'scp target/*.jar user@remote-server:/path/to/deploy/'
       //     }
     //   }
    }
}
