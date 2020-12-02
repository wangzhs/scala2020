package com.wzs

/**
 * @Author wangzhs
 * @create 2020/12/2 11:20
 */
object LogMain {
  def main(args: Array[String]): Unit = {
    Log.printLog("报错了", "ERROR")
  }

  object Log {
    def printLog(message: String, level: String = "Info"): Unit = println(s"$level,$message")
  }

}
