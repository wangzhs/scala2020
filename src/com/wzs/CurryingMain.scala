package com.wzs

/**
 * @Author wangzhs
 * @create 2020/12/2 18:39
 *         柯里化
 */
object CurryingMain {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 8)
    list.foldLeft(0)((m, n) => m + n)

    // TODO: 这个_ _ 需要深入学习
    println(list.foldLeft(0)(_ + _))
    list.foldLeft(List[Int]())_

    // 隐式参数 后面待学
    // def execute(arg: Int)(implicit ec: ExecutionContext) = ???

  }
}
