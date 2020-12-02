package com.wzs

import jdk.nashorn.internal.objects.StringIterator

/**
 * @Author wangzhs
 * @create 2020/12/2 14:25
 *         混入
 */
object MixInMain {
  def main(args: Array[String]): Unit = {
    val d = new D
    println(d.message)
    println(d.up)

    val iterator = new RichStringIterator
    iterator foreach println
  }

  abstract class A {
    val message: String;
  }

  class B extends A {
    override val message: String = "i am B";
  }

  trait C extends A {
    //    同理
    def up: String = message.toUpperCase

    //    up: String =>
    //    message.toUpperCase();
  }

  class D extends B with C {

  }

  abstract class AbsIterator {
    type T

    def hasNext: Boolean

    def next: T
  }

  class StringIterator(str: String = "") extends AbsIterator {
    private var index: Int = 0;
    override type T = Char

    override def hasNext: Boolean = str.length > index

    override def next = {
      val c = str charAt index
      index += 1
      c
    }
  }

  trait RichIterator extends AbsIterator {
    // 传入了一个方法进去 执行方法
    def foreach(f: T => Unit): Unit = while (hasNext) f(next)
  }

  class RichStringIterator extends StringIterator("name") with RichIterator {

  }

}
