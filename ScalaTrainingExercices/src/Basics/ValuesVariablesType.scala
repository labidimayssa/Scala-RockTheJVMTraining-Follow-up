package Basics

object ValuesVariablesType extends App {


  /**
   * val are immutable can't be reassigned
   */
  val x: Int = 42
  println(x)

  /**
   * Var mutable
   */
  var aVariable: Int = 1
  println(aVariable)
  aVariable = 5
  println(aVariable)
  /**
   *   recommended to prefer vals over vars
   *   compiler automatically infers types when omitted
   */

  val aString: String = "Hello"
  val anotherString = "goodbye"


  /**
   *   Instruction Vs Expressions
   *   Instructions are doing Something , tell the computer to do in imperative languages like Java or Python, you work with instructions
   *   Expressions are something that has a value AND OR a type
   *   In Scala abd in functional programming in general, we'll think in term of expressions
   */
  //IF expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3
  println(aConditionValue)
  println(if (aCondition) 5 else 3)

  // LOOPS !! very specific to imperative programming not Scala
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  //!!! Never write  this again, do not use loops in Scala code
  // EVERYTHING In scala is an Expression
}
