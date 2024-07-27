package Basics

import scala.annotation.tailrec

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

  /**   println(factorial(50000)) ==> Crash with StackOverflowError that happen because the recursive depth is too big and the stack is limited
   *Solution : write code in a smart way
   */


  def anotherFactorial (n:Int) : BigInt = {
    @tailrec
    def factHelper(x:Int, accumulator : Int) : BigInt = {
    if (x <= 1) accumulator
    else   factHelper(x-1, x*accumulator) //TAIL RECURSION = use recursive call as the LAST expression

    }
    factHelper(n,1)
  }
  /*
  anotherFactorial(10) = factHelper(10,1)
                       = factHelper(9,10*1)
                       = factHelper(8,9* 10*1)
                       = factHelper(7,8* 9*10*1)
                       = ...
                       = factHelper(2,3* 4*5*6*7*8*9*10*1)
                       = factHelper(1,2* 3*4*5*6*7*8*9*10*1)
                       = 2* 3*4*5*6*7*8*9*10*1)
   */
  anotherFactorial(50000)

  /**
   * ==> Scala in this case preserve the same stack frame and not use additionnal stack frames for recursive calls
   * in the previous implementation Scala needed a recursive call stack frame for each recursive call,so that it computes the intermediate result
   * ==> When YOU NEED LOOPS, Use _TAIL_RECURSION
   */

  /**
   * 1. Concatenate a String n times
   * 2. IsPrime function tail recursive
   * 3. Fibonacci function, tail recursive
   */


def concatenateTailrec(aString : String, n: Int) : String = {

  @tailrec
  def Helper(x:Int, s : String ,accumulator : String):String = {
    if(x<=1) s+accumulator
    else Helper(x-1,s,accumulator + s)
  }

  Helper(n,aString,"")
}
  println(concatenateTailrec("Hello", 10))

def isPrimeTailREc(n:Int): Boolean = {

  /* Basic Recursion version
  def div(x:Int) : Boolean = {
    if (x <= 1) true
    else n % x != 0 && div(x - 1)
  }
  val d = n/2
  div(d)

   */
  @tailrec
  def div(x:Int, isStillPrime : Boolean):Boolean = {
    if(!isStillPrime) false
    else if(x<= 1) true
    else div(x-1, isStillPrime && n%x!=0)
  }
  val d = n/2
  div(d,true)

}
  println(isPrimeTailREc(2003))
  println(isPrimeTailREc(629))

 /* Basic Recursion version */
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  /* New Tail REC fibonacci function */

  def fibonacciTailRec(n:Int) : Int = {
   @tailrec
    def Helper(x: Int, last : Int, nextToLast : Int) : Int = {
    if(x>=n)  last
    else Helper(x+1, last +nextToLast, last )
    }
    if(n<=2) 1
    else
      Helper(2,1,1)
  }
println(fibonacciTailRec(8))
}
