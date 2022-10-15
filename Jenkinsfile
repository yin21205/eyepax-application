pipeline {
// agent { docker { image 'maven:3.3.3' } }
    agent any

environment {
		DOCKERHUB_CREDENTIALS=credentials('dockerhub-cred-yasitha')
	}

stages {
    stage('build') {
        steps {
            sh '/Users/yasithaherath/.sdkman/candidates/maven/current/bin/mvn --version'
            sh '/Users/yasithaherath/.sdkman/candidates/maven/current/bin/mvn clean install'
        }
    }

    stage('docker image build'){
        steps{
            // sh 'export PATH="/usr/local/bin:$PATH"'
            sh '/usr/local/bin/docker build -t naveendra/spring-log .'
        }
    }

    stage('Login') {

		steps {
			sh 'echo $DOCKERHUB_CREDENTIALS_PSW | /usr/local/bin/docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
		}
	}


    stage('Push') {

		    steps {
				sh '/usr/local/bin/docker push naveendra/spring-log:latest'
		    }
	    }
    }
}