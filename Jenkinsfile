node{
    stage('Checkout') {
        checkout scm
    }

    stage('Test') {
        sh 'ls -la'
    }

    withEnv([
        'SERVICE=order-service',
    ]){
        stage('Build') {
            sh './build.sh'
        }
    }

    withEnv([
        'SERVICE=order-service',
        'PROFILES=dev'
    ]){
        stage('Deploy') {
            sh './deploy.sh'
        }
    }


}
