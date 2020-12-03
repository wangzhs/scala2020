package com.wzs

/**
 * @Author wangzhs
 * @create 2020/12/3 9:29
 */
object CaseMain extends App {
  //默认的apply方法来负责对象的创建
  private val scalaBook: Book = Book("Scala编程")
  println(scalaBook.name)

  //  scala的案列对象创建比较
  private val scalaBook2: Book = Book("Scala编程")
  //  scalaBook和scalaBook2是不同的对象，但是比较的时候，是比较他们的值是否相等
  println(scalaBook == scalaBook2)

  // 一般使用案例类创建不可变对象 参数不推荐使用val修饰
  case class Book(name: String);

  //  案列对象的copy
  private val copyBook1: Book = scalaBook.copy()
  println(copyBook1.name)

  private val copyBook2: Book = scalaBook.copy(name = "Scala编程进阶")
  println(copyBook2.name)
}
