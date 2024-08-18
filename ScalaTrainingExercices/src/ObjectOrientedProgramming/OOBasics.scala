package ObjectOrientedProgramming

object OOBasics extends App {


  val person = new Person("John", 25)  /** Instantiation the class person */
  /** at every instantiation of the class person the whole block of code of the class will be evaluated */

  println(person.age) // not work if age was a parameter because parameters are not fields, needs to  add the key word val or var
  person.greet("Daniel")


  val author = new Writer("Marc", "Levy",1961)
  val novel = new Novel("si c'était à refaire",2012, author)
  println("author age", novel.authorAge)
  println(novel.isWrittenBy(author))

  val counter = new Counter(10)
  println(counter.count)
  println(counter.inc().inc(100).count)
}



class Person(name:String, val age : Int) /** Constructor and !! class parameters are not fields*/ {
  // body = fields and methods
  val x = 2

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")


  /**
   * Overloading means supplying the methods with the same name but different signatures:
   * that means different number of parameters or parameters of different types
   */

  /** Multiple constructors */

  def this(name: String) = this(name, 0)

  def this() = this("John")


  /** Exercise 1*/
  /** writer : first name, surname, year
   * method : full name
   * novel = name, year of release and an author
   * author Age (age of the author at the year of release
   * isWrittenBy(author)
   * copy : (new year of release ) = new instance of novel with new year of release
   * */



 /** Exercise 2 */
  /**
   * receives an int value
   * method current count
   * method to increment /decrement => new Counter
   * overload inc/dec to receive an amount
   * */
}

class Writer(firstname : String, surname : String, val year : Int) {
  def fullname(): Unit = {
    println(s"${this.firstname}" + " " + s"${this.surname}")
  }
}

class Novel(name : String, year:Int, author : Writer){
  def authorAge : Int = this.year - author.year
  def isWrittenBy(author:Writer) = author == this.author

  def copy(newYear: Int): Novel = new Novel(this.name, newYear, this.author)

}

class Counter(n:Int) {
  def count = n
  def inc() = new Counter(n+1)
  def dec() = new Counter(n-1)

  def inc(amount : Int) = new Counter(n + amount)
  def dec(amount : Int) = new Counter(n - amount)
}




