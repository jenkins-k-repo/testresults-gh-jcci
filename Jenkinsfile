pipeline {
    agent any

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=true"
    }

      tools {
        maven 'Maven 3'
    }

   
    stages {    
        stage('Build & Test') {
    steps {
        dir('spring-unit-testing-example') {
            sh 'mvn clean test'
        }
    }
}


       stage('Publish Test Results') {
    steps {
        dir('spring-unit-testing-example') {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
    
    }
    post {
        always {
            echo 'Pipeline completed.'
        }
        failure {
            echo 'Build or tests failed!'
        }
    }
}