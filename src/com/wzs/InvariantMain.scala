package com.wzs

import scala.::

/**
 * @Author wangzhs
 * @create 2020/12/7 14:59
 *         型变
 *         todo 不好理解
 */
object InvariantMain extends App {

  class Animal

  class Dog extends Animal

  class Cat extends Animal

  //  private val dogs: List[Dog] = List(new Dog, new Animal)
  // 表示可协变 +A
  private val dogs: List[Animal] = List(new Dog, new Animal)

  //  逆变 父类可以子类
  abstract class Printer[-A] {
    def print(value: A): Unit
  }

  class AnimalPrinter extends Printer[Animal] {
    override def print(value: Animal): Unit = println("i am animal")
  }

  class CatPrinter extends Printer[Cat] {
    override def print(value: Cat): Unit = println("i am cat")
  }

  def printCat(printer: Printer[Cat]) = printer.print(new Cat)

  printCat(new AnimalPrinter)

  //   不变
  class Container[A](a: A) {
    private var _value: A = a

    def value: A = _value

    def value_=(value: A): Unit = {
      _value = value
    }
  }

  //  private val catContainer: Container[Cat] = new Container[Cat](new Cat)
  //  val animalContainer: Container[Animal] = catContainer
  //  animalContainer.value = new Cat
  //  val cat: Cat = catContainer.value

}
