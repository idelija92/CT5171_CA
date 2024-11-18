pipeline {
    agent any
    tools {
        git 'Default'
    }
    stages {
        stage ('GetProject') {
            steps {
                git branch:'main', url:'https://github.com/idelija92/CT5171_CA'
            }
        }
        stage ('Build') {
            steps {
                sh 'mvn clean:clean'
            }
        }
        stage ('Archive') {
            steps {
                archiveArtifacts allowEmptyArchive: true,
                artifacts:'**/demo*.war'
            }
        }
    }
}