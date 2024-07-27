package FunctionalProgramming

object HOFCurries  extends  App{


  /**
   * discuss in depth a solid brick of functional programming fundamentals
   * we are going to talk about higher order function and curried functions
   */

  val Superfunction :(Int,(String, (Int => Boolean)) => Int) => (Int=>Int) = null
  /** this function takes
   param 1 = Int
   param2 : function that takes :
   param2.1  = String
   param2.2 = function that takes Int and return Boolean
   Return param Int
   Return a function that takes Int and return Int

   //this is called a higher order function (HOF)
   */

  /** define  a function that applies a function n times over a value x
   * nTimes(f,n,x)
   */

  def nTimes(f:Int =>Int,n:Int, x:Int ) : Int = {
    if(n<=1) f(x)
    else  nTimes(f, n-1, f(x))

  }
  val plusOne : Int => Int = x=> x+1

  println(nTimes(plusOne,10,1))

  def nTimesBetter (f:Int => Int, n:Int): (Int => Int) = {

    if( n<=1) (x:Int) => f(x)
    else (x:Int) => nTimesBetter(f, n-1)(f(x))
  }

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

}
