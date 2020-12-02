package com.wzs

import scala.collection.mutable.ArrayBuffer

/**
 * @Author wangzhs
 * @create 2020/12/2 11:39
 *         特质
 */
object TraitMain {
  def main(args: Array[String]): Unit = {
    val iterator = new IntIterator(10)
    while (iterator.hasNext) {
      println(iterator.next())
    }
//    报错
//    println(iterator.next())

    val animals = ArrayBuffer.empty[Pet]
    animals.append(new Dog());
    animals.append(new Cat());

    animals.foreach(v => v.printKind())
  }

  class IntIterator(val to: Int) extends Iterator[Int] {
    private var current: Int = 0

    override def hasNext: Boolean = current < to

    override def next(): Int = {
      if (hasNext) {
        val t = current
        current += 1
        t
      } else {
        throw new RuntimeException("没了 最大值了");
      }
    }
  }

  trait Pet {
    val kind: String;

    def printKind() = println(this.kind);
  }

  class Dog(val kind: String = "dog") extends Pet {
    override def toString: String = s"$kind"
  }

  class Cat extends Pet{
    override val kind: String = "Cat"
    override def toString: String = s"$kind"
  }


}
