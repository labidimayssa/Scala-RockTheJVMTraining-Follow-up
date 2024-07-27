package FunctionalProgramming

object WhatAFunction extends App {

  /** Dream: Use functions as first class elements: pass a function as parameters and values */
  /** problem : Scala works on the top of the JVM
   designed for JAVA which the first class elements are instance of classes  */
  /** Solution : ALL Scala functions are Objects */



  private trait MyFunction[A,B] {
    def apply (element: A) :B
  }


  private val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2)) // doubler which is an instance of a function like class can be called as a function

private val StringToIntConverter = new Function[String, Int] {
  override  def apply (element: String) : Int = element.toInt
}

  println(StringToIntConverter("3") + 4)


  val adder: (Int, Int) => Int = new ((Int, Int) => Int) {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function type Function2[A,B,R] === (A,B)=>R
  //ALL SCALA FUNCTIONS are Objects

  private def concat: (String, String) => String = new((String, String) => String) {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(concat("Hello ", "John"))

  /**
   * define a function which takes an int and returns another function add which takes an int ans returns an int
   * whats is the tyê of this function
   * how to do it
   * */
  val  superAdder: Function1[Int,Function1[Int, Int]]  = new Function1[Int,Function1[Int, Int]] {
    override def apply(x:Int) : Function1[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x+ y
    }

  }

  val adder3 = superAdder(3) // adder3 is a new Function in which is a function1 from int to int
  println(adder3(4)) // adder3 is the implementation of apply(y: Int): Int = x+ y
  // this is called a curried function they can be called by multiple parameter list

println(superAdder(3)(4))
}
