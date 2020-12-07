package com.wzs

/**
 * @Author wangzhs
 * @create 2020/12/7 16:12
 */
object TypeMain extends App {

  //   类型上限
  abstract class Animal {
    def name: String

    println(name)
  }

  abstract class Pet extends Animal {
    override def name: String
  }

  class Dog extends Pet {
    override def name: String = "DOG"
  }

  class Cat extends Pet {
    override def name: String = "CAT"
  }

  class Lion extends Animal {
    override def name: String = "LION"
  }

  //  <: 上限是PET
  class PetContainer[P <: Pet](p: P) {
    def pet: P = p
  }

  private val cat = new PetContainer[Cat](new Cat)
  private val dog = new PetContainer[Dog](new Dog)
  private val pet = new PetContainer[Pet](new Pet {
    override def name: String = "pet"
  })

  //  上限为PET对象，只能为PET子类或者PET实现
  //  编译报错
  //  private val lion = new PetContainer[Lion](new Lion)


  //  超下限 todo 需要在理解
  trait Node[+B] {
    def prepend[U >: B](elem: U): Node[U]
  }

  case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
    override def prepend[U >: B](elem: U): Node[U] = ListNode(elem, this)

    def head: B = h

    def tail: Node[B] = t
  }

  case class Nil[+B]() extends Node[B] {
    override def prepend[U >: B](elem: U): ListNode[U] = ListNode(elem, this)
  }

  trait Bird

  case class AfricanSwallow() extends Bird

  case class EuropeanSwallow() extends Bird

  val africanSwallowList = ListNode[AfricanSwallow](AfricanSwallow(), Nil())
  val birdList: Node[Bird] = africanSwallowList
  birdList.prepend(EuropeanSwallow())
}
