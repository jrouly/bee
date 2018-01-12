pipeline {
  agent any

  environment {
    sbt = "${tool name: 'sbt-0.13.15', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt"
  }

  stages {

    stage('Build') {
      steps {
        sh "$sbt compile test:compile"
      }
    }

    stage('Test') {
      steps {
        sh "$sbt test"
        junit '**/target/test-reports/*.xml'
      }
    }

  }

}
