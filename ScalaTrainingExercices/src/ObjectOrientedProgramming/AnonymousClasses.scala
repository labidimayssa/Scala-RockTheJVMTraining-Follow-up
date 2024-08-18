package ObjectOrientedProgramming

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }
  // Anonymous class

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahahahahahaha")
  }

  /** equivalent with
   *
   *class AnonymousClasses$$anon$1 extends Animal {
   *override def eat: Unit =  println("ahahahahahahahahaha")
   *}
   *
   *val funnyAnimal : Animal = new AnonymousClasses$$anon$1()
   *this is what the compiler does behind the scenes
   */
  println(funnyAnimal.getClass)

  class Person(name: String) {

    def saysHi: Unit = println(s"Hi, my name is $name, how can I help ?")
  }

  val jim = new Person("Jim") {
    override def saysHi: Unit = println(s"Hi, my name is Jim, how can I be of service ?")
  }
}
