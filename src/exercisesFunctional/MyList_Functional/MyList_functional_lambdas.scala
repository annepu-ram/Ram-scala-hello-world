/*package exercisesFunctional.MyList_Functional

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
  def map[B](transformer: A=>B):MyList[B]
  def flatMap[B](transformer: A=>MyList[B]):MyList[B]
  def filter(predicate: ((A)=>Boolean)):MyList[A]
  def ++[B >: A](list:MyList[B]):MyList[B] //concatenation method for two lists
}


//Nothing is the proper substitute of anything, so make any object such as empty a proper substitute
//of any generic type of class exercises.MyList_Functional.MyList we pass nothing type parameter
//the Nothing type //nothing is concrete type
case object Empty extends MyList[Nothing]{

  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](value:B): MyList[B] = new Cons[B](value, Empty)
  override def printElements: String = ""
  def map[B](transformer: Nothing=>B):MyList[B]=Empty
  def flatMap[B](transformer: Nothing=>MyList[B]):MyList[B]=Empty
  def filter(predicate: ((Nothing)=>Boolean)):MyList[Nothing]=Empty
  def ++[B >: Nothing](list:MyList[B]):MyList[B] = list //empty concatenated with anything returns that list
}


case class Cons[+A] (h:A, t:MyList[A]) extends MyList[A] {

  def head = h
  def tail:MyList[A] = t

  override def isEmpty: Boolean = false
  override def add[B >: A](value: B): MyList[B] = new Cons[B](value, this) //this pass the current object
  override def printElements ={
    def helper(accu:String, value:MyList[A]): String= {
      if (value.isEmpty)
        accu
      else helper(accu = accu + " " + value.head, value.tail)
    }
      helper("",this)
    }

  def filter(predicate: A=>Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: A=>B):MyList[B] =
    new Cons(transformer(h),t.map(transformer))

  /*
  [1,2] ++ [3,4,5]
  = new cons(1, [2] ++ [3,4,5])
  = new cons(1, new cons(2,exercises.MyList_Functional.MyListses.MyList_Functional.MyList.exercises.MyList_Functional.Empty ++[3,4,5])
  = new cons(1, new cons(2,new cons(3, new cons(4, new cons (5,exercises.MyList_Functional.MyListses.MyList_Functional.MyList.exercises.MyList_Functional.Empty)))))
   */
  def ++[B >: A](list:MyList[B]):MyList[B] = new Cons (h, t ++ list)

  def flatMap[B](transformer: A=>MyList[B]):MyList[B] =
    transformer(h) ++ t.flatMap(transformer)
  }



object Main_function extends App {
  val listOfInt:MyList[Int] = new Cons(1,new Cons(2,new Cons(6, Empty)))
  val anotherListOfInt:MyList[Int] = new Cons(4,new Cons(5,new Cons(8, Empty)))
  val listOfString:MyList[String] = new Cons("hello",new Cons("There",new Cons("How", new Cons("Are", new Cons("You", Empty)))))
  println(listOfInt.toString)
  println(listOfString.toString)

  val doubler :(Int => Int)= (elem:Int)=> elem * 2

  println(listOfInt.map[Int](doubler).toString) //anonymous functions

  val predicate = new ((Int)=>Boolean) {
    override def apply(elem: Int): Boolean = elem % 2 == 0
  }

  println(listOfInt.filter((x:Int) => x % 2 == 0).toString) // anonymous function or lambda

  val transform : (Int => MyList[Int]) = (elem:Int)=> new Cons(elem, new Cons(elem + 1,Empty))

  println(listOfInt ++ anotherListOfInt)
  println(listOfInt.flatMap((elem:Int)=> new Cons(elem, new Cons(elem + 1,Empty))).toString) //above transform function as lambda
}

 */