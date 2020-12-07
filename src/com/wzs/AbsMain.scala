package com.wzs

/**
 * @Author wangzhs
 * @create 2020/12/7 17:32
 */
object AbsMain extends App {

  trait Buffer {
    type T
    val element: T
  }

  abstract class SeqBuffer extends Buffer {
    type U
    type T <: Seq[U]

    def length = element.length
  }

  abstract class IntBuffer extends SeqBuffer {
    type U = Int
  }

  def newIntSeq(x: Int, y: Int): IntBuffer = {
    new IntBuffer {
      override type T = List[U]
      override val element: List[U] = List(x, y)
    }
  }

  private val buffer: IntBuffer = newIntSeq(1, 2)
  buffer.element.foreach(println)

  abstract class Buffer2[+T] {
    val element: T
  }

  abstract class SeqBuffer2[U, +T <: Seq[U]] extends Buffer2[T] {
    def length = element.length
  }

  def newIntSeq2(i: Int, j: Int): SeqBuffer2[Int, List[Int]] = {
    new SeqBuffer2[Int, List[Int]] {
      override val element: List[Int] = List(i, j)
    }
  }

  private val value: SeqBuffer2[Int, List[Int]] = newIntSeq2(3, 4)
  value.element.foreach(println)


  abstract class IntBuffer2[Int, List[Int]] extends SeqBuffer2[Int, List[Int]] {
  }

  def newIntSeq3(i: Int, j: Int) {
    new IntBuffer2[Int, List[Int]] {
      override val element: List[Int] = List(i, j)
    }
  }
}
