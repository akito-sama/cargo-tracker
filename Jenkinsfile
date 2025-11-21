pipeline {
    agent any

    triggers {
        githubPush()   
    }

    stages {

        stage('Clone') {
            steps {
                git branch: 'develop', url: 'https://github.com/akito-sama/cargo-tracker.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean verify'
            }
        }

        stage('SonarQube Analysis') {
            environment {
                SONAR_TOKEN = credentials('sonar-token-id')
            }
            steps {
                withSonarQubeEnv('SonarQube Local') {
                    bat """
                        mvn sonar:sonar ^
                        -Dsonar.projectKey=cargo-tracker ^
                        -Dsonar.projectName="Cargo Tracker" ^
                        -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml ^
                        -Dsonar.host.url=http://localhost:9000 ^
                        -Dsonar.token=%SONAR_TOKEN%
                    """
                }
            }
        }

        stage('Docker Build & Push') {
            environment {
                DOCKER_TOKEN = credentials('docker-token-id')
            }
            steps {
                script {
                    // login securely
                    bat """
                    echo %DOCKER_TOKEN% | docker login -u mouadensafir --password-stdin
                    """

                    // build and tag
                    bat "docker build -t cargo-tracker ."
                    bat "docker tag cargo-tracker mouadensafir/cargo-tracker:latest"

                    // push with sequential uploads
                    bat "docker push mouadensafir/cargo-tracker:latest"
                }
            }
        }



        stage('Run App') {
            steps {
                script {
                    // stop old container if exists
                    bat 'docker rm -f cargo-tracker-app || echo "No existing container"'

                    // run new one
                    bat 'docker run -d -p 8080:8080 -p 4848:4848 --name cargo-tracker-app cargo-tracker'
                }
            }
        }


    }

    post {
        success {
            echo 'Build et analyse terminés avec succès !'
        }
        failure {
            echo 'Échec du build ou des tests.'
        }
    }
}
