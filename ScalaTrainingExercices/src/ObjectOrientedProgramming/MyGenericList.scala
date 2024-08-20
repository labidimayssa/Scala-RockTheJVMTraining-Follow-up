package ObjectOrientedProgramming


abstract class MyGenericList[+A] {
  /*
  head = first element of the list
  tail = reminder of the list
  isEmpty = is this list empty
  add(int) => new list with this element added
  toString => a string representation of the list
  */
  def head: A

  def tail: MyGenericList[A]

  def isEmpty: Boolean

  def add[B>: A](elment: B): MyGenericList[B]

  def printElements: String


  //Polymorphic call
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer : MyTransformer[A,B]) : MyGenericList[B]

  // CONCATENATION
  def  ++[B >: A] (list : MyGenericList[B] ): MyGenericList[B]
  def flatMap[B](transformer : MyTransformer[A, MyGenericList[B]]) : MyGenericList[B]
  def filter (predicate: MyPredicate[A]) : MyGenericList[A]



}

object EmptyGeneric extends MyGenericList[Nothing] {

  def head: Nothing = throw new NoSuchElementException

  def tail: MyGenericList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >:Nothing](element: B): MyGenericList[B]= new ConsGeneric(element, EmptyGeneric)

  def printElements: String = ""

  def map[B](transformer : MyTransformer[Nothing,B]) : MyGenericList[B] = EmptyGeneric
  def flatMap[B](transformer : MyTransformer[Nothing, MyGenericList[B]]) : MyGenericList[B] = EmptyGeneric
  def filter (predicate: MyPredicate[Nothing]) : MyGenericList[Nothing] = EmptyGeneric

  def  ++[B >: Nothing] (list : MyGenericList[B] ): MyGenericList[B] = list

}

class ConsGeneric[+A](h: A, t: MyGenericList[A]) extends MyGenericList[A] {
  def head: A = h

  def tail: MyGenericList[A] = t

  def isEmpty: Boolean = false

  def add[B>:A](element: B): MyGenericList[B] = new ConsGeneric(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  //def map[B](transformer : MyTransformer[A,B]) : MyGenericList[B]
  //def flatMap[B](transformer : MyTransformer[A, MyGenericList[B]]) : MyGenericList[B]
  def filter (predicate: MyPredicate[A]) : MyGenericList[A] =
    if(predicate.test(h)) new ConsGeneric[A](h, t.filter(predicate))
    else t.filter(predicate)


  /*
  [1,2,3].map(n*2) = new ConsGeneric(2, [2,3].map(n*2))
          = new ConsGeneric ( 2, new ConsGeneric(4, [3].map(n*2))
          = new ConsGeneric ( 2, new ConsGeneric(4, newConsGeneric(6, Empty.map(n*2) )))


   */
  def map[B](transformer : MyTransformer[A,B]) : MyGenericList[B] = {

     new ConsGeneric[B](transformer.transform(h),t.map(transformer))
  }

 /*[1,2]  ++ [3,4,5]

 = new ConsGeneric(1,[2] ++ [3,4,5]  )
 = new ConsGeneric (1, new ConsGeneric(2,Empty ++ [3,4,5] ))
 = new ConsGeneric(1,new ConsGeneric(2,new ConsGeneric(3,[4,5])))
  */

  def  ++[B >: A] (list : MyGenericList[B] ): MyGenericList[B] = {
    new ConsGeneric[B](h, t ++ list)
  }

  def flatMap[B](transformer : MyTransformer[A, MyGenericList[B]]) : MyGenericList[B] = {
   transformer.transform(h) ++ t.flatMap(transformer)
  }

  /*
  [1,2].flatMap(n => [n, n+1])
  = [1,2] ++ [2].flatMap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ Empty = [1,2,2,3]
   */
}


trait MyPredicate[-T]  {
  def test(elem : T) : Boolean
}
trait MyTransformer[-A,B] {
  def transform(elem:A) : B
}

object listGenericTest extends App {

  val listOfIntegers : MyGenericList[Int] = new ConsGeneric(1, new ConsGeneric(2, new ConsGeneric[Int](3, EmptyGeneric)))
  val listOfStrings : MyGenericList[String] = new ConsGeneric("Hello", new ConsGeneric[String]("Scala", EmptyGeneric))

  println(listOfStrings.toString)
  println(listOfIntegers.toString)

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }))

  println(listOfIntegers.filter(new MyPredicate[Int]{
    override def test(elem: Int): Boolean = if (elem %2 == 0) true
    else false
  }))
  val AnotherListOfIntegers : MyGenericList[Int]  = new ConsGeneric(4, new ConsGeneric(5, new ConsGeneric[Int](6, EmptyGeneric)))
println(listOfIntegers ++ AnotherListOfIntegers)


  println(listOfIntegers.flatMap( new MyTransformer[Int,MyGenericList[Int]] {
    override def transform(elem: Int): MyGenericList[Int] = new ConsGeneric(elem,new ConsGeneric(elem+1, EmptyGeneric))
  }))
  /** takeaways !!!
   * Variance Problem : If B extends A , should list[B] extend list [A]
   * yes ( covariant)  example : trait list[+A]
   * no the default one and it is Invariant : trait list [A]
   * hell no !! contravariant  : trait List[-A]
   */

}
