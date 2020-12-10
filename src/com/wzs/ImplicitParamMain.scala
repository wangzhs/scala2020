package com.wzs

import com.wzs.ImplicitParamMain.ImplicitTest.sum

/**
 * @Author wangzhs
 * @create 2020/12/7 18:41
 *
 *         todo 隐式转换
 */
object ImplicitParamMain {

  abstract class Monoid[A] {
    def add(x: A, y: A): A

    def unit: A
  }

  object ImplicitTest {
    implicit val stringMonoid: Monoid[String] = new Monoid[String] {
      override def add(x: String, y: String): String = x concat y

      override def unit: String = ""
    }

    implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
      override def add(x: Int, y: Int): Int = x + y

      override def unit: Int = 0
    }

    def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
      if (xs.isEmpty) m.unit else m.add(xs.head, sum(xs.tail))

    def print: Unit = {
      println(sum(List("aa", "dd")))
      println(sum(List(111, 333)))
    }

  }

  def main(args: Array[String]): Unit = {
    ImplicitTest.print
  }

}
