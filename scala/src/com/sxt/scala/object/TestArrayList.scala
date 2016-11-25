package com.sxt.scala.`object`

import java.util._

object TestArrayList {
  def main(args: Array[String]) {
    //	  var val
    //	  java === scala  变  声明
    var arr = new ArrayList[Any];
    arr.add(123);
    arr.add("gaga");
    println(arr)
    println(arr.get(0))
    val it = arr.iterator();
    while (it.hasNext()) {
      println(it.next());
    }

  }
}