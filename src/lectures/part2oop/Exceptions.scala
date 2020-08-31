package lectures.part2oop

object Exceptions extends App  {

  val x:String = null
  //println(x.length) //throws null pointer exceptions
  //exceptions are run time errors

  //throwing an exception, it is an expression in scala
  //val stupidValue = throw new NullPointerException //stupid value holds nothing
  //throwable classes extend throwable class
  // type Exception and Error are major throwable subtypes
  //error are system errors like stack overflow error

  def exceptionThrower(returnInt:Boolean):Int =
    if(!returnInt) throw new RuntimeException("not passed an int buddy")
    else 42

  val tryCatchFinally =  //since everything is an expression in scala, this is AnyVal expression
  // because try is int anf except is unit
  try{
    exceptionThrower(false)
  }
  catch{
    case e: RuntimeException => println("caught runtime exception")
    case e: NullPointerException => println("caught nullpointer exception")
  }
  finally{
    //finally is optional
    //finally doesn't influence the return type of try except expression block
    //use finally for side effects
    println("finally")
  }

}
