package com.wzs

/**
 * @Author wangzhs
 * @create 2020/12/2 13:36
 */
object TupleMain {

  def main(args: Array[String]): Unit = {
    // 创建元素
    val tuple = ("hello", true): (String, Boolean);
    val tuple1 = Tuple2("hello", true);
    val tuple2 = ("hello", true): Tuple2[String, Boolean];
    println(tuple)

    // 数组调用
    println(tuple._1)
    println(tuple._2)

    // 数组解构
    val (a, b) = tuple1
    println(a);
    println(b)

    //  元组解构用于匹配模式
    val planetDistanceFromSun = List(("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6), ("Mars", 227.9), ("Jupiter", 778.3))
    planetDistanceFromSun.foreach {
      case t@("Mercury", d) => println(t)
      case p if p._1 == "Venus" => println(p)
      case t@(a, 149.6) => println(t)
      // 默认case
      case _ => println("Too far....")
    }

    // for循环
    val numPairs = List((2, 5), (3, -7), (20, 56))
    for ((a, b) <- numPairs) {
      println(a * b)
    }

    numPairs.foreach(v => println(v))
  }

}
