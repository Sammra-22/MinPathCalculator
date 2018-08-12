package com.utility

import java.io.{BufferedReader, IOException, InputStream, InputStreamReader}

package object minimizer {

  @throws(classOf[IOException])
  def readInputStream(input: InputStream): Stream[String] = {
    val br = new BufferedReader(new InputStreamReader(input))
    Stream.continually(br.readLine()).takeWhile(l => l != null && l != "EOF")
  }

  @throws(classOf[NumberFormatException])
  def parseTriangleLine(line: String): Array[Int] = {
    line.trim().split("\\s+").filter(_.nonEmpty).map(_.toInt)
  }

  @throws(classOf[NoSuchElementException])
  def calculateMinPath(paths: List[List[Int]]): Seq[Int] = {
    paths match {
      case head :: tail =>
        if (paths.size > 1) {
          val tailMinPath = calculateMinPath(tail)
          if (head.sum < tailMinPath.sum) head else tailMinPath
        } else head
      case _ => throw new java.util.NoSuchElementException
    }
  }
}
