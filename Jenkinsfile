#!groovy
@Library('jenkins-sharelibrary') _

def tools = new org.devops.tools()
hello()

String workspace = "/data/jenkins"
pipeline {
    agent { node { label "master" //指定运行节点的标签或名称
                    customWorkspace "${workspace}"
            }
    }
    options {
        timestamps()  //显示日志时间
        skipDefaultCheckout() //删除隐式checkout scm语句
        disableConcurrentBuilds() //禁止并行
        timeout(time: 1, unit: 'HOURS')  //流水线超时时间1小时
    }
    stages {
        //下载代码
        stage("GetCode"){ //阶段名称
            steps{  //步骤
                timeout(time: 5, unit: 'MINUTES'){ //步骤超时时间
                    script {
                        println('获取代码')
                    }
                }
            }
        }
        //构建
        stage("Build"){
            steps{
                timeout(time: 5, unit: 'MINUTES'){
                    script {
                        println('应用编译打包')
                    }
                }
            }
        }
        //代码扫描
        stage("CodeScan"){
            steps{
                timeout(time: 10, unit: 'MINUTES'){
                    script {
                        println('代码扫描')
                        tools.PrintMes("hello, my is sharelibrary!")
                    }
                }
            }
        }
    }
    //构建后操作
    post {
        always {
            script{
                println('总是执行')
            }
        }
        success {
            script {
                currentBuild.description = "构建成功"
            }
        }
        failure {
           script {
               currentBuild.description = "构建失败"
            }
        }
        aborted {
            script {
                currentBuild.description = "取消构建"
            }
        }
    }
}
