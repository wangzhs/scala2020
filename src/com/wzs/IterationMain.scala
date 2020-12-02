package com.wzs

import scala.annotation.tailrec

/**
 * @Author wangzhs
 * @create 2020/12/2 18:24
 */
object IterationMain {

  def main(args: Array[String]): Unit = {
    // 迭代方法
    println(factFunction(2))
  }

  private def factFunction(x: Int = 2): Int = {
    def fact(x: Int, y: Int): Int = {
      if (x < 1) y else fact(x - 1, x * y)
    }

    fact(x, 1)
  }

}
