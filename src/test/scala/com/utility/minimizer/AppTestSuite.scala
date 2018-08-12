package com.utility.minimizer

import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class AppTestSuite extends FunSuite {

  test("Parse triangle line with correct input") {
    assert(parseTriangleLine("1") === Array(1))
    assert(parseTriangleLine("3 6") === Array(3, 6))
    assert(parseTriangleLine("3  9") === Array(3, 9))
  }

  test("Parse triangle line with wrong input") {
    val thrown = intercept[Exception] {
      parseTriangleLine("lala")
    }
    assert(thrown.isInstanceOf[NumberFormatException])
  }

  test("Build tree with correct input") {
    val rootNode = TreeNode.generateTree(List("1", "3 5", "7 8 9"))
    assert(rootNode.value === 1)
    assert(rootNode.left.get.value === 3)
    assert(rootNode.right.get.value === 5)
    assert(rootNode.right.get.left.get.value === 8)
    assert(rootNode.right.get.right.get.value === 9)
  }

  test("Build tree with non Integer input") {
    val thrown = intercept[Exception] {
      TreeNode.generateTree(List("1", "3 d"))
    }
    assert(thrown.isInstanceOf[NumberFormatException])
  }

  test("Build tree with non triangle input") {
    val thrown = intercept[Exception] {
      TreeNode.generateTree(List("1", "3 8 9"))
    }
    assert(thrown.isInstanceOf[IllegalArgumentException])
  }

  test("Generate single path test") {
    val paths = TreeNode.generatePaths(new TreeNode(5))
    assert(paths.size === 1)
    assert(paths.head === List(5))
  }

  test("Generate multiple paths test") {
    val paths = TreeNode.generatePaths(new TreeNode(5,
      Some(new TreeNode(3)),
      Some(new TreeNode(2))))
    assert(paths.size === 2)
    assert(paths.head === List(5, 3))
    assert(paths.tail.head === List(5, 2))
  }
}
