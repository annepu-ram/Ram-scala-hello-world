package lectures.part3funcp

object AnonymousFunctions extends App {
  val doubler: Int => Int = (x: Int) => x * 2
  //or
  val doubler2: Int => Int = x => x * 2
  //This is called anonymous functions or lambda
  //multiple parameters in lambda
  val adder = (a: Int, b: Int) => a + b
  //longer version with type declaration
  val adderVer2: (Int, Int) => Int = (x: Int, y: Int) => x + y

  //no params lambda
  val func3 = () => 3

  println(func3)
  println(func3()) //always use this call not above call

  //more syntactical sugar
  val plusOneShort: (Int => Int) = _ + 1
  val adderShort: (Int, Int) => Int = _ + _



  //Exercises
  val specialAdder:(Int => (Int => Int))= (v1:Int) => (v2:Int)=> v1+v2

  println(specialAdder(2)(9))
}