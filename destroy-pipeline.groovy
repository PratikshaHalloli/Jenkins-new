

pipeline {
    agent any

    stages {

        stage('PULL-INFRA-CODE') {
            steps {
                git branch: 'main', url: 'https://github.com/PratikshaHalloli/eks-infra.git'
            }
        }

        stage('TERRAFORM-INIT') {
            steps {
                sh 'terraform init'
            }
        }

        stage('CONFIRM-DESTROY') {
            steps {
                input message: 'This will DESTROY the EKS cluster and all infra. Are you sure?', ok: 'Yes, destroy it'
            }
        }

        stage('TERRAFORM-DESTROY') {
            steps {
                sh 'terraform destroy -auto-approve'
            }
        }
    }
}