pipeline {
    agent any
    tools {
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
    }
}
