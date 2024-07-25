package Basics

object Recursion  extends App {

  def factorial(n:Int) : Int = {
    if(n<=1) 1
    else {
      println(s"Computing Factorial of " + n + "  : I first need to compute factorial of " + (n-1))
      val result =  n* factorial(n-1)
      println("computed factorial of " +n)
      result
    }
  }

  println(factorial(10))

  /**   println(factorial(50000)) ==> Crash with .StackOverflowError that happen because the recursive depth is too big
   *Solution : write code in a smart way
   */



}
