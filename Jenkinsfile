pipeline {
  environment {
    registry = "suchithkumarch/scical"
    registryCredential = 'DockerHubCred'
    dockerImage = ''
  }
  agent any
  stages {
    stage('GIT CLONE') {
      steps {
        git 'https://github.com/suchithkumarch/SciCal'
      }
    }
    stage('MVN COMPILE') {
      steps {
        echo "Compiling the source Java classes of the project"
		sh "mvn compile"
      }
    }
    stage('MVN TEST') {
      steps {
        echo "Running the test cases of the project"
        sh "mvn test"
      }
    }
    stage('MVN INSTALL') {
      steps {
        echo "building the project and installs the project files(JAR) to the local repository"
        sh "mvn install"
      }
    }
    stage('Building Docker image') {
      steps{
        script {
          echo "Building Docker image"
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
    stage('Deploy Docker Image') {
      steps{
        script {
          echo "Deploying Docker Image to " + registry
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push('latest')
          }
        }
      }
    }
    stage('Remove unused/untagged docker images') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
        sh "docker image prune"
      }
    }
    stage('Ansible') {
      steps{
        ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible',  playbook: 'scical.yml', sudoUser: null
      }
    }    
  }
}

