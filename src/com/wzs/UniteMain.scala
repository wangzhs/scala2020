package com.wzs

/**
 * @Author wangzhs
 * @create 2020/12/2 9:46
 *         统一类型
 */
object UniteMain {

  def main(args: Array[String]): Unit = {
    // Any是所有类的父类
    val list: List[Any] = List("a string", 732, 'c', true, () => println("test"))
    list.foreach(v => {
      println(v)
    })

    // 9种类型 额外 Boolean/Unit
    // 类型转换
    // Byte => Short => Int => Long => Float => Double
    // Char => Int
    var a: Int = 1;
    var b: Long = a;
    println(b)

    val c: Char = 'k';
    val d: Int = c;
    println(d)

    // Nothing Null 待理解
  }
}
