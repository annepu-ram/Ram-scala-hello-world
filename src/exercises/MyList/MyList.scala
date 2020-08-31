/*
package exercises.MyList

//package exercises


abstract class MyList[+A] { //lists should in theory be covariant
  /*
  head = first element of the list
  tail = remainder of the  list
  isEmpty returns whether the list is empty
  add(int) add element to the list
  toString = entire list in string format
   */
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](value:B): MyList[B]
  protected def printElements:String //polymorphic call: because appropriate printElements is automatically called
  override def toString:String = "["+ printElements +" ]" //toString is present in any ref class so we have to override
  def map[B](transformer: MyTransformer[A,B]):MyList[B]
  def flatMap[B](transformer: MyTransformer[A,MyList[B]]):MyList[B]
  def filter(predicate: MyPredicate[A]):MyList[A]
  def ++[B >: A](list:MyList[B]):MyList[B] //concatenation method for two lists
}


//Nothing is the proper substitute of anything, so make any object such as empty a proper substitute
//of any generic type of class exercises.MyList_Functional.MyList we pass nothing type parameter
//the Nothing type //nothing is concrete type
case object Empty extends MyList[Nothing]{

  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](value:B): MyList[B] = new Node[B](value, Empty)
  override def printElements: String = ""
  def map[B](transformer: MyTransformer[Nothing,B]):MyList[B]=Empty
  def flatMap[B](transformer: MyTransformer[Nothing,MyList[B]]):MyList[B]=Empty
  def filter(predicate: MyPredicate[Nothing]):MyList[Nothing]=Empty
  def ++[B >: Nothing](list:MyList[B]):MyList[B] = list //empty concatenated with anything returns that list
}


case class Node[+A] (h:A, t:MyList[A]) extends MyList[A] {

  def head = h //like a getter method
  def tail:MyList[A] = t //getter method for tail

  override def isEmpty: Boolean = false
  override def add[B >: A](value: B): MyList[B] = new Node[B](value, this) //this pass the current object
  override def printElements ={
    def helper(accu:String, value:MyList[A]): String= {
      if (value.isEmpty)
        accu
      else helper(accu = accu + " " + value.head, value.tail)
    }
      helper("",this)
    }

  def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new Node(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: MyTransformer[A,B]):MyList[B] =
    new Node(transformer.transform(h),t.map(transformer))

  /*
  [1,2] ++ [3,4,5]
  = new cons(1, [2] ++ [3,4,5])
  = new cons(1, new cons(2,exercises.MyList_Functional.MyListses.MyList_Functional.MyList.exercises.MyList_Functional.Empty ++[3,4,5])
  = new cons(1, new cons(2,new cons(3, new cons(4, new cons (5,exercises.MyList_Functional.MyListses.MyList_Functional.MyList.exercises.MyList_Functional.Empty)))))
   */
  def ++[B >: A](list:MyList[B]):MyList[B] = new Node (h, t ++ list)

  def flatMap[B](transformer: MyTransformer[A,MyList[B]]):MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)
  }

trait MyPredicate[-T]{
  def test(elem:T):Boolean
}

trait MyTransformer[-A, B]{
  def transform(elem:A):B
}

object Main_3 extends App {
  val listOfInt:MyList[Int] = new Node(1,new Node(2,new Node(6, Empty)))
  val anotherListOfInt:MyList[Int] = new Node(4,new Node(5,new Node(8, Empty)))
  val listOfString:MyList[String] = new Node("hello",new Node("There",new Node("How", new Node("Are", new Node("You", Empty)))))
  println(listOfInt.toString)
  println(listOfString.toString)

  println(listOfInt.map[Int](new MyTransformer[Int,Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(listOfInt.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  println(listOfInt ++ anotherListOfInt)
  println(listOfInt.flatMap(new MyTransformer[Int, MyList[Int]] {
  override def transform(elem:Int): MyList[Int] = new Node(elem, new Node(elem + 1,Empty))
  }).toString)
}

 */