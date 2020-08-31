package lectures.part1basics

object DefaultArgsNamedArgs extends App {

  def trFactorial(n:Int=3):BigInt ={
    def factHlp(n:Int,accumulator:BigInt):BigInt=    //default values passed to parameter
    {
      if (n<1) accumulator
      else factHlp(n-1,n*accumulator)
    }
    factHlp(n,1)
  }
  println(trFactorial(5))
  println(trFactorial(n = 6)) //named parameters
  //we cannot omit leading default arguments.
}
