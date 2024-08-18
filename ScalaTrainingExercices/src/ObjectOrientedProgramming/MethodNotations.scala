package ObjectOrientedProgramming

object MethodNotations extends App {

  /** Create the class person inside the object because otherwise it would conflict with the other classes inside the same package */
  class Person(val name: String, favoriteMovie: String, var age: Int) {

    def likes(movie: String): Boolean = movie == this.favoriteMovie

    //def hangOutWith(person:Person) : String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(nickname: String): Person = new Person(this.name + " (" + nickname + ")", this.favoriteMovie, this.age)

    def unary_! : String = s"$name, what the heck ?!"

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is ${name} and I like $favoriteMovie"

    def apply(x: Int): String = apply() + " " + s"$x times"

    def learns(sthingtolearn: String) = s"$name is learning $sthingtolearn"

    def islearing(): String = learns("Scala")
  }


  val mary = new Person("Marry", "Inception", 23)
  println(mary.likes("Inception"))

  /** Infix notation */
  println(mary likes ("Inception"))

  val tom = new Person("Tom", "Fight Club", 25)

  /** Operators  in Scala */
  //println(marry hangOutWith tom )
  println(mary + tom)

  /** ==> all operators are methods */
  println(mary.+(tom))


  /** prefix notation */
  val x = -1
  val y = 1.unary_- // unary prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  /** postfix notation */
  println(mary.isAlive)
  println(mary isAlive) // available only for methods without parameters

  /** apply */

  println(mary.apply())
  println(mary()) // equivalent

  /** Exercises */
  println(mary.+("the Rockstar").apply())
  println(mary.unary_+.age)
  println((+mary).age)

  println(mary islearing())
  println(mary(2))
  /*
  1. Overload the + Operator  : mary + "the rock star" => new Person

  2. Add an age to the person class
  Add a unary operation => new person with the age + 1
  +mary => mary with the age incrementer

  3. Add a "learns" method in the Person class => "Mary learns Scala"
  Add a learnScala method, calls learns method with "Scala"
  use it in postfix notation

  4. Overload the apply method
     marr.apply(2) => "Mary watched Inception 2 times"

   */

}
