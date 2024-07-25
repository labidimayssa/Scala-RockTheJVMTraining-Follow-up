package Basics

object ValuesVariablesType  extends  App{


  /**
   * val are immutable can't be reassigned
   */
  val x : Int = 42
  println(x)

  /**
   * Var mutable
   */
  var aVariable : Int = 1
  println(aVariable)
  aVariable = 5
  println(aVariable)
  /**
   *   recommended to prefer vals over vars
   *   compiler automatically infers types when omitted
   */

  val aString : String = "Hello"
  val anotherString ="goodbye"
}
