package com.utility.minimizer


class TreeNode(val value: Int,
               var left: Option[TreeNode] = None,
               var right: Option[TreeNode] = None) {


}

object TreeNode {

  @throws(classOf[IllegalArgumentException])
  @throws(classOf[NumberFormatException])
  def buildTree(triangleLines: Seq[String], directParents: Seq[TreeNode]): Unit = triangleLines match {
    case Nil =>
    case _ =>
      val values = parseTriangleLine(triangleLines.head)
      if (values.length != directParents.size + 1) throw new IllegalArgumentException
      for (i <- directParents.indices) {
        directParents(i).left = Some(new TreeNode(values(i)))
        directParents(i).right = Some(new TreeNode(values(i + 1)))
      }
      if (triangleLines.tail.nonEmpty) {
        buildTree(triangleLines.tail, directParents.flatMap(node => Seq(node.left.get, node.right.get)))
      }
  }
}
