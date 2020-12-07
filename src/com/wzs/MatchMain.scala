package com.wzs

import scala.util.Random

/**
 * @Author wangzhs
 * @create 2020/12/3 9:45
 */
object MatchMain extends App {
  private val intList: Int = Random.nextInt(10)
  //简单匹配
  intList match {
    case 1 => println("one")
    case 2 => println("two")
    case 3 => println("three")
    case _ => println("other")
  }

//

}
