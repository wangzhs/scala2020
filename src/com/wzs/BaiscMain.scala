package com.wzs

/**
 * @Author wangzhs
 * @create 2020/12/1 21:34
 */
object BaiscMain {
  def main(args: Array[String]): Unit = {
    println(1 + 1);

    // val修饰常量 不能重新赋值
    val a = 1 + 1;
    println(a);
    // 显式声明类型
    val b: String = "test"
    println(b);

    // var 变量 可修改值
    var c = 333;
    c = 444;
    var d: Int = 555;

    // 代码块
    println({
      val x = 1 + 1;
      x + 11;
    });

    // 带参函数
    val e = (x: Int) => x + 1;
    println(e(1));

    // 多个参数
    val g = (x: Int, y: Int) => x + y;
    println(g(1, 3));

    // 不带参
    val f = () => 1;
    println(f());

    // 方法
    def add(x: Int, y: Int): Int = x + y;
    println(add(1, 3));

    // 多个参数列表 柯里化
    def add2(x: Int, y: Int)(z: Int): Int = x + y + z;
    println(add2(11, 11)(22));

    // 无参方法
    def sout(): String = System.getProperty("user.name");
    println(sout());

    def sout2: String = System.getProperty("user.name");
    println(sout2);

    // 方法函数代码块
    def getSquareString(input: Double): String = {
      val square = input * input
      // 默认最后一行为返回值 也可以用 return square.toString;
      square.toString
    }

    println(getSquareString(2.5))

    // 初始化类
    val j = new Greeter("hello", "!");
    j.greet("wangzhs");

    // 对比样例类  样例类可以不用new
    val point = new Point(1, 1);
    val point1 = Point(1, 2);
    val point2 = Point(2, 3);

    println(point == point1);
    println(point1 == point2);

    // 访问对象
    println(IdFactory.add())
    println(IdFactory.add())

    val k = new GreetClass()
    k.greet("11");
    k.greet2("111");
  }

  // 类
  class Greeter(prefix: String, suffix: String) {
    def greet(name: String): Unit = {
      println(s"$prefix$name$suffix")
    }
  }

  // 样例类
  case class Point(x: Int, y: Int) {

  }

  // 对象
  object IdFactory {
    private var a = 0;

    def add(): Int = {
      a = a + 1;
      a;
    };
  }

  // 特质
  trait GreetTrait {
    def greet(name: String);

    def greet2(name: String): Unit = {
      println(2222)
    }
  }

  class GreetClass extends GreetTrait {
    override def greet(name: String): Unit = {
      println(1111)
    }

    override def greet2(name: String): Unit = {
      println(3333)
    }
  }

  object GreetObject extends GreetTrait{
    override def greet(name: String): Unit = {

    }

  }

}
