package com.wzs

/**
 * @Author wangzhs
 * @create 2020/12/7 14:14
 */
object ForMain extends App {

  def foo(x: Int, r: Int) = {
    for (i <- 0 to x;
         j <- i to x if i + j == r)
      yield (i, j)
  }

  foo(10, 10).foreach(println)
}
