package com.utility.minimizer


case class TreeNode(value: Int,
                    var left: Option[TreeNode] = None,
                    var right: Option[TreeNode] = None) {


  private def buildRootedTree(triangle: List[String]): Unit = {

    def appendNodes(triangleLines: Seq[String], directParents: Seq[TreeNode]) {
      triangleLines match {
        case head :: tail =>
          val values = parseTriangleLine(head)
          if (values.length != directParents.size + 1) throw new IllegalArgumentException
          val childNodes = values.map(v => Some(new TreeNode(v))).toSeq
          for (i <- directParents.indices) {
            directParents(i).left = childNodes(i)
            directParents(i).right = childNodes(i+1)
          }
          if (tail.nonEmpty) {
            appendNodes(triangleLines.tail, childNodes.map(n => n.get))
          }
      }
    }

    triangle match {
      case _ :: tail if tail.nonEmpty => appendNodes(tail, Seq(this))
      case _ =>
    }
  }

}

object TreeNode {

  def generateTree(triangle: List[String]): TreeNode = {
    parseTriangleLine(triangle.head).toList match {
      case head :: tail if tail.isEmpty =>
        val rootNode = new TreeNode(head)
        rootNode.buildRootedTree(triangle)
        rootNode
      case _ => throw new IllegalArgumentException
    }
  }

  def generatePaths(headNode: TreeNode): List[List[Int]] = {
    headNode match {
      case TreeNode(value, Some(leftNode), Some(rightNode)) =>
        (generatePaths(leftNode) ::: generatePaths(rightNode)).map(path => value :: path)
      case _ => List(List(headNode.value))
    }
  }

}
