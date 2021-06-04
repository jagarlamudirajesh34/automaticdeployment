pipeline {
    agent any
    tools {
        maven 'maven3'
        git 'Default'
    }
   
    stages{
        stage('git Repo Pull'){
            steps{
                sh 'git --version'
                sh 'whereis git'
                git 'https://github.com/jagarlamudirajesh34/automaticdeployment.git'
            }
        }
        stage('maven clean'){
            steps{
                sh 'mvn clean'
                sh 'mvn install'
            }
        }
    }
}
