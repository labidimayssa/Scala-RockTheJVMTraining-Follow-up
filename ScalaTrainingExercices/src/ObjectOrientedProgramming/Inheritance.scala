package ObjectOrientedProgramming

object Inheritance extends App {

  /** Extending a class means inheriting all non-private fields and methods */

  /** Single class inheritance */

  sealed class Animal {
    private def x = "" // the sub class cannot inherit  a private field , private fields or methods

    // are accessible only within this class only
    protected def y = "" // usable within this class and within subclasses

    def eat = println("nomnom")

    val creatureType = "Wild"

  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch, crunch ")
    }

  }

  val cat = new Cat
  cat.crunch

  /** cat.eat is not accessible outside the sub class because it's protected */

  //Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  /** JVM Rule, when you instantiate a derived class, in this case Adult, the JVM will need to call
   *a constructor from a parent class first */


  class Dog(override val creatureType: String) extends Animal {
    override def eat = {
      super.eat
      println("Crunch, Crunch")
    }

    //override val creatureType: String =  "Domestic"
  }

  val dog = new Dog("k2")
  println(dog.eat)
  println(dog.creatureType)

  /** Polymorphism */
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  /** preventing overrides
   * 1- use final on member
   * 2- use final on the entire class
   * 3- seal the class = extend classes in this file only but prevent extension in other files
   */
}
