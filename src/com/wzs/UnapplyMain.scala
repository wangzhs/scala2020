package com.wzs

import scala.util.Random

/**
 * @Author wangzhs
 * @create 2020/12/7 11:55
 *
 *         提取器对象
 */
object UnapplyMain extends App {

  //  require(true)

  object ID {
    def apply(name: String): String = s"${name}--${Random.nextLong}"

    def unapply(id: String): Option[String] = {
      val splits = id.split("--")
      if (splits.tail.nonEmpty) Some(splits.head) else None
    }
  }

  private val test: String = ID("test")

  test match {
    case ID(name) => println(name + "1111")
    case _ => println("error")
  }

}
