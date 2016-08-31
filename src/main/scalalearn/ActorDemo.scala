package scalalearn

import scala.actors._
import Actor._
/**
  * Created by lason on 7/8/16.
  */
object ActorDemo {
  def main(args : Array[String]) =
  {
    val badActor =
      actor
      {
        receive
        {
          case msg => System.out.println(msg)
        }
      }

    badActor ! "Do ya feel lucky, punk?"
  }
}

object Actor2
{
  case class Speak(line : String);
  case class Gesture(bodyPart : String, action : String);
  case class NegotiateNewContract;

  def main(args : Array[String]) =
  {
    val badActor =
      actor
      {
        receive
        {
          case NegotiateNewContract =>
            System.out.println("I won't do it for less than $1 million!")
          case Speak(line) =>
            System.out.println(line)
          case Gesture(bodyPart, action) =>
            System.out.println("(" + action + "s " + bodyPart + ")")
          case _ =>
            System.out.println("Huh? I'll be in my trailer.")
        }
      }

    badActor ! NegotiateNewContract
    badActor ! Speak("Do ya feel lucky, punk?")
    badActor ! Gesture("face", "grimaces")
    badActor ! Speak("Well, do ya?")
  }
}

