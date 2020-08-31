package lectures.part2oop

object ExceptionsExercise extends App {
  class Person(){

  }
//OutOfMemory error occurs when memory allocated exceeds java vm memory
  // we can do that by creating an array of max value
    //  val array = Array.ofDim(Int.MaxValue)


//StackOverflow error occurs when program exceeds stack memory
//infinite recursive functions throws these errors
/* def summation(y:Int):Int={
    val result =summation(y+1)

    result
  }
  summation(1)*/

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by zero")


  object pocketCalculator {
    def add(x:Int, y:Int):Int = {
      val result: Int = x + y
      if(x>0 && y>0 && result<0) throw new OverflowException
      else if(x<0 && y<0 && result>0) throw new UnderflowException
      else
      result
    }
    def subtract(x:Int, y:Int):Int = {
      val result: Int = x - y
      if(x>0 && y<0 && result<0) throw new OverflowException
      else if(x<0 && y>0 && result>0) throw new UnderflowException
      else
        result
    }
    def multiply(x:Int, y:Int):Int = {
      val result: Int = x * y
      if(x>0 && y>0 && result<0) throw new OverflowException
      else if(x<0 && y<0 && result<0) throw new OverflowException
      else if(x>0 && y<0 && result>0) throw new UnderflowException
      else if(x<0 && y>0 && result>0) throw new UnderflowException
      else
        result
    }
    def divide(x:Int, y:Int):Int = {

      if(y==0) throw new MathCalculationException
      //else if(x<0 && y<0 && result<0) throw new UnderflowException
      else
        x / y
    }

  }
  println(pocketCalculator.divide(7,0))
}
