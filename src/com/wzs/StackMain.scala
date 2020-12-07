package com.wzs

import scala.::

/**
 * @Author wangzhs
 * @create 2020/12/7 14:25
 */
object StackMain extends App {

  class Stack[A] {
    private var elements: List[A] = Nil

    def push(a: A) = elements = a :: elements


    def peek: A = elements.head

    def pop: A = {
      // TODO: elements 可能为空
      val head = elements.head
      elements = elements.tail
      head
    }

    def foreachPrint = elements.foreach(println)
  }

  private val ints = new Stack[Int]
//  ints.pop
  ints.push(1)
  ints.push(2)
  ints.foreachPrint
  ints.pop
  ints.foreachPrint

  class Fruit
  class Apple extends Fruit
  class Orange extends  Fruit

  private val fruits = new Stack[Fruit]
  fruits.push(new Apple)
  fruits.push(new Orange)
  fruits.foreachPrint
}
