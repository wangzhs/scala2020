package com.wzs

import com.wzs.EnterMain.{graph1, graph2}

/**
 * @Author wangzhs
 * @create 2020/12/7 17:06
 */
object EnterMain extends App {

  private val graph1 = new Graph
  private val node1: graph1.Node = graph1.newNode
  private val node2: graph1.Node = graph1.newNode
  node1.connectTo(node2)

  private val graph2 = new Graph
  private val node3: graph2.Node = graph2.newNode

  // 内部类 只能内部使用
  // 在connectTo上参数用Graph#Node可以对象之间互相调用
  // node3.connectTo(node2)

  class Graph {

    class Node {
      var connectedNodes: List[Node] = Nil

      //Graph#Node
      def connectTo(node: Node): Unit = {
        if (!connectedNodes.exists(node.equals))
          node :: connectedNodes
      }
    }

    var nodes: List[Node] = Nil

    def newNode: Node = {
      val node = new Node
      nodes = node :: nodes
      node
    }

  }

}
