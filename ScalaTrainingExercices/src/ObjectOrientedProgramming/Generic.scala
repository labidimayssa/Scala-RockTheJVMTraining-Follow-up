package ObjectOrientedProgramming

object Generic extends App {
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]
  //val emptyListOfIntegers = MyList.empty[Int]

  class MyList[+A] /* the type A denotes a generic type*/ {
    // This code explains how  we can add a dog to a list of cat and that will return a list of animal
    //def add[B>:A](element : B) : MyList[B] = ???
    /* A = Cat
       B = Dog = Animal
       Add an animal into a list of cat we will get a list of animals */
  }

  class MyMap[key, value]

  // generic methods
  object MyList {
    //def empty[A]: MyList[A] = ???
  }


  /** Variance problem */
  class Animal

  class Cat extends Animal /** yes List[Cat] extends list [Animal] = covariance */

  class Dog extends Animal

  class CovarianceList[+A] // + means this is a covariant list

  val animal: Animal = new Cat()
  val animalList: CovarianceList[Animal] = new CovarianceList[Cat]

  /** animalList.add(new Dog) ???, when the answer is no the problem is an invariant problem
   * when the answer is yes that means we return a list of animals and we will use bounded Type*/

  /**  2. NO  = INVARIANCE */
  class InvariantList[A] // Invariant list means that every type is in its own world and we cannot substitute one for other we cannot put dogs and cats together

  val InvariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  /** 3. CONTRAVARIANCE */
  class ContravariantList[-A]

  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]

  /** Contravariance is the opposite relation to covariance */

  /** ==> We have 3 variance options : Covariance, invariance and contravariance*/

  //bounded type
  class Cage[A <: Animal](animal: A) {
    /** Class Cage only accepts Animal subTypes and takes a parameter Animal */
      val newCage = new Cage(new Dog)

  }
}








