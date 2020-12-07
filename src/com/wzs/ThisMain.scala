package com.wzs

/**
 * @Author wangzhs
 * @create 2020/12/7 18:23
 */
object ThisMain extends App {

  trait User {
    def username: String
  }

  // TODO: 自类型的意义
  trait Tweeter {
    this: User =>
    def tweeter(text: String) = println(s"text + $username")
  }

  class VerTweeter(val name: String) extends Tweeter with User {
    override def username = s"real + $name"
  }

  private val tweeter = new VerTweeter("test")
  tweeter.tweeter("aaaa")

}
