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
        stage ('Package') {
            steps {
                sh 'mvn package'
            }
        }
        stage ('Archive') {
            steps {
                archiveArtifacts allowEmptyArchive: true,
                artifacts:'**/demo*.war'
            }
        }
        stage('Approval') {
            def userInput = input message: 'Do you want to deploy?',
                                  parameters: [booleanParam(defaultValue: false, description: '', name: 'Proceed')]

            if (!userInput) {
                error 'Deployment aborted by user!'
            }
        }
        stage ('Deploy') {
            when {
                expression { params.CONFIRM_DEPLOY }
            }
            steps {
                sh 'docker build -f Dockerfile -t myapp . '
                sh 'docker rm -f "myappcontainer" || true'
                sh 'docker run --name "myappcontainer" -p 9090:8080 --detach myapp:latest'
            }
        }
    }
}