package com.utility.minimizer

import java.io.IOException

import scala.collection.mutable.ListBuffer


object MainApp extends App {

  try {
    val triangle = ListBuffer[String]()
    readInputStream(System.in).foreach(triangle += _)

    triangle.toList match {
      case _ :: _ =>
        val treeRoot = TreeNode.generateTree(triangle.toList)
        TreeNode.generatePaths(treeRoot).foreach(path =>
          println(path)
        )
      case _ => println("Empty triangle!")
    }

  } catch {
    case _: IOException => println("Error while reading the stream")
    case _: NumberFormatException => println("Invalid input: only integers allowed")
    case _: IllegalArgumentException => println("Invalid input: not a correct triangle")
  }

}



