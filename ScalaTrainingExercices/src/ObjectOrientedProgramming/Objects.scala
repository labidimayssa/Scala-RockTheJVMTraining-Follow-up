package ObjectOrientedProgramming

object Objects {

  object Person { // Object can have values, vars and method definition
    // "static"/"class" - level functionality
    val N_EYES = 2

    def canFly: Boolean = false

    //factory methode
    def apply(mother: Person, father: Person) = new Person("Bobbie")

  }

  /** Scala does not have class-level functionality ("static") values/methods, it has Scala Objects
   *Scala Objects: singleton pattern in one line !! */

  /** Scala Object = SINGLETON INSTANCE
   *SINGLETON : There is a single instance that ca be referred to with the name person */

  val mary = Person
  val john = Person
  println(mary == john)


  /** COMPANIONS : Objects and classes with the same name in the same scope
   *the whole code that will ever write will reside in either a class and we access it from and instance,
   *Or it will reside inside on a singleton Object and we can access that by accessing the singleton object.
   */

  class Person(val name: String) {
    /** Instance-level functionality */

  }

  val mary_ = new Person("mary")
  val john_ = new Person("john")
  println(mary_ == john_)

  //Scala Applications = Scala Object with
  // def main(args:Array[String]):Unit OR extends App

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)
    val bobbie = Person.apply(mary_, john_)
  }

}
