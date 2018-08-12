package com.utility.minimizer

import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

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
    val rootNode = new TreeNode(1)
    TreeNode.buildTree(Seq("3 5", "7 8 9"), Seq(rootNode))
    assert(rootNode.value === 1)
    assert(rootNode.left.get.value === 3)
    assert(rootNode.right.get.value === 5)
    assert(rootNode.right.get.left.get.value === 8)
    assert(rootNode.right.get.right.get.value === 9)
  }

  test("Build tree with non Integer input") {
    val rootNode = new TreeNode(1)
    val thrown = intercept[Exception] {
      TreeNode.buildTree(Seq("3 d"), Seq(rootNode))
    }
    assert(thrown.isInstanceOf[NumberFormatException])
  }

  test("Build tree with non triangle input") {
    val rootNode = new TreeNode(1)
    val thrown = intercept[Exception] {
      TreeNode.buildTree(Seq("3 8 9"), Seq(rootNode))
    }
    assert(thrown.isInstanceOf[IllegalArgumentException])
  }
}
