package com.wzs

/**
 * @Author wangzhs
 * @create 2020/12/2 10:20
 */
object ClassMain {

  def main(args: Array[String]): Unit = {
    // 无参对象
    val user = new User
    val user1 = new User()
    val user2 = new User()

    println(user == user1)
    println(user1 == user2)

    // 带参对象，并用var修饰，可更改数据
    val point = new Point(3, 4)
    point.move(1, 2)
    println(point)
    println(point.toString)

    //    val point1 = new Point2()
    val point1 = new Point2(1)
    println(point1)
    // 构造器可以给参数提供默认值，可以指定属性的值
    val point2 = new Point2(y = 2)
    println(point2)

    // set/get方法赋值
    val point3 = new Point3
    point3.x = 111
    println(point3)
  }

  class User {

  }

  class Point(var x: Int, var y: Int) {
    def move(x: Int, y: Int): Unit = {
      this.x = this.x - x;
      this.y = this.y - y;
    }

    override def toString: String = s"$x,$y"
  }

  class Point2(var x: Int = 0, var y: Int = 0) {
    override def toString: String = s"$x,$y"
  }

  // 私有成员变量
  class Point3 {
    private[this] var _x: Int = _

    def x: Int = _x

    def x_=(value: Int): Unit = {
      // 同等于 if(value < 100) _x = value else printWaring
      if (value < 100) {
        _x = value
      } else {
        printWaring();
      }
    }

    // 如果没有参数就可以去掉括号
    private def printWaring(): Unit = print("waring ++++")

    override def toString: String = s"$x"
  }

  //不带val或var的构造函数参数是私有的，仅在类中可见。
  class Point4(x: Int, y: Int) {

  }

}
