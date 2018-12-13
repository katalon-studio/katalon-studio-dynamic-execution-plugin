pipeline {
    agent any
   
    tools {
        maven 'default'
    }
    
    stages {
    
        stage('Prepare') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }   
        }
        
        stage('Copy plugin') {
            steps {
                dir("target") {
                    script {
                        String tmpDir = "/tmp/kataplugin/${BRANCH_NAME}_${BUILD_TIMESTAMP}"
                        fileOperations([
                                fileCopyOperation(
                                        excludes: '',
                                        includes: '*.jar,
                                        flattenFiles: true,
                                        targetLocation: "${tmpDir}")
                        ])
                    }
                }
            }
        }    
    }
}
