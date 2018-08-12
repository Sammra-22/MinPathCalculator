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
    line.trim().split("\\s+").map(_.toInt)
  }

}
