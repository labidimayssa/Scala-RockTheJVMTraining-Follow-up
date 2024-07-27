package FunctionalProgramming

object AnonymousFunctions extends App{

  val doubler1 = new Function1[Int, Int] {
    override  def apply(x:Int) : Int = x*2
  }
  // In Scala the practical way is to define a function this way

  val debouler2 : Int => Int = x => x*2 // doubler 1 ans 2 are equivalent
  /** doubler1 is basically the oriented way of defining an anonymous function */
  /** doubler2 is a Scala Implementation that instantiates a new function1
   * with the override def apply that takes an x  and returns x*2
   * => is the syntactic sugar  and it is called  an Anonymous Function or a LAMBDA*/


  //  Lambda function
  //Multiple parameters
  val adder : (Int,Int) => Int = (x,y) => x+y
  //no params
  val noparamfunction : ()=>Int = ()=>3
  println(noparamfunction) // function itself
  println(noparamfunction()) // call of the function


  //Syntactic Sugar
  val incrementer : Int => Int = _ +1
  val niceAdder : (Int, Int) => Int = _ + _



  /**
   * 2.Rewrite the "special" adder as an anonymous function
   *  define a function which takes an int and returns another function add which takes an int ans returns an int
   * */

  val specialfunction : Int => ((Int) => Int) = x => (y => x+y)

  println(specialfunction(5)(6))


  /**
   * Instead of passing anonymous Function X instances every time that
   * cumbersome
   * still object Oriented !!
   * Solution : Use Lambda functions
   * */
}
