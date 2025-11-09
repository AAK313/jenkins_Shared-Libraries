def call(String projectDir, String fileName, String kubeconfigId) {
    stage('Deploy to Kubernetes') {
        dir(projectDir) {
            withCredentials([file(credentialsId: kubeconfigId, variable: 'KUBECONFIG')]) {
                sh """
                    kubectl --kubeconfig=$KUBECONFIG apply -f ${fileName}
                """
            }
        }
    }
}
