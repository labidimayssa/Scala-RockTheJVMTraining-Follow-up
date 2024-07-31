package Basics


object Functions extends App {
  def aFunction(a: String, b: String): String = {
    a + " " + b
  }

  println(aFunction("hello", "John"))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)


  /**
   *  1. A greeting function  ( name, age) => My name is $name and I am $age years old."
   *     2. factorial function
   *     3. a Fibonacci function
   *     f(1) = 1
   *     f(2) = 1
   *     f(n) = f(n-1) + f(n-2)
   *     4. Tests if the number is Prime
   */

  def greeting(name: String, age: Int): String = {
    s"Hello my name is $name and I am $age years old."
  }

  println(greeting("John", 40))

  def factorial(n: Int): Int = {

    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  println(factorial(4)) //24
  println(factorial(5)) //120

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(8)) //21


  def isPrime(n: Int): Boolean = {

    def div(d: Int): Boolean = {
      if (d <= 1) true
      else n % d != 0 && div(d - 1)

    }

    div(n / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))

  /**
   * Type Inference : what the compiler knows and able to figure out when we don't specify types explicitly
   */

  val message = "Hello, world !"
  val x = 2
  val y = x + "Items" /* Int + String = String */


  def succ(x: Int) = x + 1 // the compiler infers the return type from the implementation
}
