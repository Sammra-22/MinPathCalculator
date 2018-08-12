package com.utility.minimizer

import java.io.IOException

import scala.collection.mutable.ListBuffer


object MainApp extends App {

  try {
    val triangleBuffer = ListBuffer[String]()
    readInputStream(System.in).foreach(triangleBuffer += _)

    val triangle = triangleBuffer.toList.filter(_.nonEmpty)
    triangle match {
      case _ :: _ =>
        val treeRoot = TreeNode.generateTree(triangle)
        val minPath = calculateMinPath(TreeNode.generatePaths(treeRoot))
        val minPathDisplay = minPath.foldLeft("")((acc, e) => acc + s" $e +").dropRight(1).trim
        println(s"Minimal path is: $minPathDisplay = ${minPath.sum}")
      case _ => println("Empty triangle!")
    }

  } catch {
    case _: IOException => println("Error while reading the stream")
    case _: NumberFormatException => println("Invalid input: only integers allowed")
    case _: IllegalArgumentException => println("Invalid input: not a correct triangle")
    case _: NoSuchElementException => println("No minimal path found")
  }

}



