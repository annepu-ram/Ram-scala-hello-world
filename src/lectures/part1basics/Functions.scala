package lectures.part1basics

object Functions extends App{

  def aFunction(a:String,b:String):String =
    {
      a+" "+b
    }
  println(aFunction("Hello","There"))

  def aFunctWithNoParams():String =
    "no params here"

  println(aFunctWithNoParams) //here a func is not passed but the function is called
  println(aFunctWithNoParams())

  //WHEN YOU NEED LOOPS USE RECURSIONS
  //Return type should always be defined for recursive functions
  def sumOfNumbers(a:Int):Int = {
    if (a == 0) 0
    else a+sumOfNumbers(a-1)
  }
  println(sumOfNumbers(10))

  //function with return type unit (similar to void): these kind of functions return a void or has only side effects
  def aUnitReturnFunc(a:Int, b:Int):Unit =println(a+b)

  //auxiliary functions, function inside a function
  def aBiggerFunction (a:Int):Int =
    {
      def aSmallerFunction (n:Int, m:Int):Int = n+m
      aSmallerFunction(a,a-1)   //output of child function is the output for parent function
    }
  println(aBiggerFunction(10))

  def afibnacci(a:Int):Int =
    {
      if (a==1 || a==2) 1
      else afibnacci(a-1)+afibnacci(a-2)

    }
  println(afibnacci(7))

  def prime(n:Int): String =
    {
      val a = n
      val f = 2
      def factorFunc(f:Int):String = {
        if (f == a || a==1) "Prime"
        else if (a % (f) == 0) "Not Prime"
        else factorFunc(f + 1)
      }
      factorFunc(f)
    }
  println(prime(4))

  def isPrime(n:Int):Boolean =
    {
      def isPrimeUntil(t:Int):Boolean =
        {
          if(t<=1) true
          else n%t !=0 && isPrimeUntil(t-1)
        }
      isPrimeUntil(n/2)
    }
  println(isPrime(12))
}
