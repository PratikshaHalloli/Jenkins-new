


pipeline{
    agent any 
    stages {
        stage ('PULL') {
            steps {
                git branch: 'main', url: 'https://github.com/PratikshaHalloli/s3.git'
            }
        }

        stage ('PLAN') {
            steps {
                sh '''terraform init 
                   terraform plan '''
            }
        }

        stage ('APPROVAL') {
            steps {
                sh 'shall we procced ok : Approve'
            }
        }

        stage ('APPLY') {
            steps {
                sh 'terraform apply -auto-approve'
            }
        }
    }
}