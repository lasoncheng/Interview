package scalalearn

import scala.reflect.ClassTag

/**
  * Created by lason on 7/5/16.
  * ClassTag
  */
private class TestDemo1(
                              private val name: String,
                              protected val sex: String
                              )
{
  def printTest = println("this is a test ")
}

private  class SubTestDemo1 extends TestDemo1("lason","test"){
  override
  def  printTest = println("this is a test ")
}

object TestDemo1 {
  def mkArray[T: ClassTag](element: T*) = Array[T](element: _*)

  def setElem[T](arr: Array[T], e: T) = {
    arr(0) = e
  }

  def main(args: Array[String]) {

    var labels  = Array.fill(2)(0.0)
    println(("0.00").toInt)
  }
}
