package lectures.part3funcp

object WhatsAFunction extends App{
  //GOAL: use functions as first class elements
  //Problem: We come from OOP

  //So to create a JVM, which is designed for OOPS, based functional language scala uses some clever tricks

  trait MyFunction[A,B]{
    def apply(element:A):B
  }
  val doubler = new MyFunction[Int,Int]{
    override def apply(element: Int): Int = element * 2
  }
  // we wrote our first function in scala on oops jvm

  println(doubler(2)) // we called like a function

  //scala supports these functions out of the box, so we dont need to create classes like above to mimic functions
  val stringToInt = new Function1[String,Int] {        //function1 takes one input parameter and gives a result and function2 takes two input parameters and so on
    override def apply(v1: String): Int = v1.toInt
  }

  //above function with type declaration looks like this
  val stringToInt2:((String)=>Int) = new Function1[String,Int] {        //function1 takes one input parameter and gives a result and function2 takes two input parameters and so on
    override def apply(v1: String): Int = v1.toInt
  }

  //also in short we can define a function as
  val stringToInt3 = new ((String) => Int) { //function1 takes one input parameter and gives a result and function2 takes two input parameters and so on
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToInt("6"))

  //all scala functions are objects

  //exercises
  //a concatenation function
  val concatStrings = new ((String, String) => String){
    override def apply(v1: String,v2: String):String = v1+v2
  }

  println(concatStrings("he","llo"))

  //a function which takes an int and returns an function that takes an int and returns an int

  val specialAdder =new (Int =>(Int=>Int)){
    override def apply(v1:Int)= new (Int=>Int){
      override def apply(v2:Int)= v1+v2
    }
  }

  val adder2 = specialAdder(2)
  println(adder2(5))
  //or
  println(specialAdder(2)(5)) /////This is function is called CURRIED FUNCTION

  ////HIGHER ORDER FUNCTIONS takes functions as parameters or returns other functions as result

  val specialMultiplier:Function1[Int, Function1[Int,Int]] = new Function1[Int, Function1[Int,Int]] {
    override def apply(v1:Int):Function1[Int,Int] =new Function1[Int,Int] {
      override def apply(v2: Int): Int = v1 * v2
    }
  }
  println(specialMultiplier(5)(6))

}
