package com.wzs

/**
 * @Author wangzhs
 * @create 2020/12/7 18:10
 */
object WithMain extends App {

  trait Clone extends Cloneable {
    override def clone(): Clone = super.clone().asInstanceOf[Clone]
  }

  trait Reset {
    def reset: Unit
  }

  def cloneAndReset(obj: Clone with Reset): Unit = {
    val c = obj.clone()
    obj.reset
    c
  }

}
