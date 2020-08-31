package lectures.part1basics

import java.util.concurrent.atomic.DoubleAccumulator

import scala.annotation.tailrec

object Recursion extends App{
  def factorial(a:Int):Int =
    if(a<=1) 1
    else {
      println("computing factorial of "+ a +" factorial of "+ (a-1)+" is needed")
      val result = a*factorial(a-1)
      println("Computed factorial of "+ a)

      result
    }

  //println(factorial(5000))
  //this recursive function crashes at 5k factorial due to stack overflow error because a new stack mem is allocated with each recursive call
  // to overcome this we adopt a new method of recursion

  def newFactorial(n:Int, accumulator :BigInt):BigInt=
    {
      @tailrec //this annotation verifies that the function is actually a tail recursion and compiler throws an error if it is'nt.
      def factHelper(n:Int, accumulator: BigInt):BigInt ={
        if (n<=1) accumulator
        else factHelper(n-1,n*accumulator)      //Tail recursion - use recursive as the last expression
      }

      factHelper(n,1)
    }
  println(newFactorial(20,1))
  //In tail recursion parameters are evaluated before passing them to the recursive expression hence the need for stack mem is eliminated.
  //accumulator holds intermediate result
  //When you need loops use tail recursion.

  //exercises
  // 1. concat string given number of time with tail recursion
  def stringConcat(n:Int, aString:String):String =
    {
      @tailrec
      def concatHelper(n:Int, aString:String, accumulator :String): String=
        if (n <= 0) accumulator
        else concatHelper(n-1,aString,accumulator+aString)
     concatHelper(n,aString,accumulator="")
    }
  println(stringConcat(5,"Ram"))

  //2. Function to determine prime numbers with tail recursion
  def isPrime(n:Int):Boolean= {
    @tailrec
    def primeHelper(m: Int, accumulator: Boolean): Boolean =
      if (m <= 1) accumulator
      else primeHelper(m - 1, (accumulator && n % m!=0))

    primeHelper(n/2,true)
  }
  println(isPrime(67))

  //3. Fibonacci series with tail rec
  def fibonacciTailrec(n:Int):BigInt=
    {
      if (n<=0) 1
      else
      {
        @tailrec
        def fibonacciHelper(m: Int, p: BigInt, accumulator: BigInt): BigInt = {
          //val q:BigInt =accumulator
          if (m == n) accumulator
          else fibonacciHelper(m + 1, accumulator, p + accumulator)
        }

        fibonacciHelper(1, 0, 1)
      }
    }
  //We have two accumulators in this functions, however many recursive calls we have in code path that many accumulators are required
  println(fibonacciTailrec(8))

}

