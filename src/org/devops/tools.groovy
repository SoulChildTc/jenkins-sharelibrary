package org.devops

// 打印内容
def PrintMes(content) {
  print(content)
}

// 带颜色打印
def Myprint(content,color) {
  colors = [
    'red': "\033[40;31m ${content} \033[0m",
    'green':  "[1;32m ${content} [m",
    'bule': "\033[47;34m ${content} \033[0m",
    'green1': "\033[40;32m ${content} \033[0m"
  ]
  ansiColor('xterm') {
    println(colors[${color}])
  }
}

// 构建类型
def build(buildType,buildShell){
  def buildTools = ['mvn': 'M2', 'npm':'NPM']

  println("当前选择的构建类型为:${buildType}")
  buildHome = tool buildTools[buildType]
  
  sh "${buildHome}/bin/${buildType} ${buildShell}"
}