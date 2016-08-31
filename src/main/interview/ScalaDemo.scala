package interview

/**
  * Created by lason on 8/7/16.
  */
class ScalaDemo(n: Int, d: Int){

  private val g = gcd(n, d);

  def this(n: Int) = this(n, 1);

  def gcd(a: Int, b: Int): Int ={
    if(b == 0) a else gcd(b, a%b);
  }

  override def toString = n/g + "/" + d/g ;
}

object ScalaDemo{
  def main(args: Array[String]) {
    new ScalaDemo(5);
  }

}
