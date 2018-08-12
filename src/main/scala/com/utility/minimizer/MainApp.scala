package com.utility.minimizer

import java.io.IOException

import scala.collection.mutable.ListBuffer


object MainApp extends App {

  try {
    val triangle = new ListBuffer[String]()
    readInputStream(System.in).foreach(triangle += _)

    val topValue = parseTriangleLine(triangle.head)
    if (topValue.length > 1) throw new IllegalArgumentException
    val rootNode = new TreeNode(topValue.head)
    TreeNode.buildTree(triangle.tail, Seq(rootNode))

  } catch {
    case _: IOException => println("Error while reading the stream")
    case _: NumberFormatException => println("Invalid input: only integers allowed")
    case _: IllegalArgumentException => println("Invalid input: not a correct triangle")
  }

}



