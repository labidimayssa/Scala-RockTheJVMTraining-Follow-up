package ObjectOrientedProgramming

object AbstractDataTypes extends App {


  /** Abstract */
  abstract class Animal {
    val creatureType: String

    def eat: Unit

  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat = println("Crunch crunch")
  }

  /** Traits */
  trait Carnivore {
    def eat(animal: Animal): Unit

    val preferredMeal: String = "fresh meat"
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Croc"

    def eat = println("nomnomnom")

    def eat(animal: Animal): Unit = println(s"I am a croc and I am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)


  /** Traits Vs Abstract Classes
   * 1- traits do not have constructor parameters
   *  2- multiple traits my be inherited by the same class
   *  3- traits = behaviour , abstract class = "type of thing"
   *
   * */

}
