package com.sxt.scala.akka

import scala.actors._, Actor._

object Actor1 {
  def main(args: Array[String]) = {
    val badActor =
      actor {
        while (true) { //nexttpule
          receive {
            case msg =>
              println(msg);
              reply("gagagagag");
          }

        }
      }

    println("Do ya feel lucky, punk?");
    println(badActor ! "dddddddddddddd"); //! 异步发送消息
    //这里的println打印的是返回来的值，也就是reply中的值
    println(badActor ! "mmmmmmmmmmmmmmm");

  }
}  
