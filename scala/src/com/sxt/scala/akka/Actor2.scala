package com.sxt.scala.akka

import scala.actors._, Actor._
object Actor2 {
  case class Speak(line: String)
  case class Gesture(bodyPart: String, action: String)
  case class NegotiateNewContract()

  def main(args: Array[String]) =
    {
      val badActor =
        actor {
          receive {
            case NegotiateNewContract =>
              println("I won't do it for less than $1 million!")
            case Speak(line) =>
              println(line)
            case Gesture(bodyPart, action) =>
              println("(" + action + "s " + bodyPart + ")")
            case _ =>
              println("Huh? I'll be in my trailer.")
          }
        }

      badActor ! NegotiateNewContract
//      badActor ! Speak("Do ya feel lucky, punk?")
//      badActor ! Gesture("face", "grimaces")
//      badActor ! Speak("Well, do ya?")
//      badActor ! "Well, do ya?"
//      Thread.sleep(3000);
    }
}  