package lectures.part1basics

object CBVnCBN extends App {

  def callByValue(x: Long)={
    println("call by value time "+x)
    println("call by value time "+x)
  }

  def callByName(x: => Long)={
    println("call by Name time "+x)
    // similar to println("call by Name time "+System.nanotime())
    println("call by Name time "+x)
  }

  //By Name call delays the function call, lazy evaluation
  callByName(System.nanoTime())
  callByValue(System.nanoTime())

  //call by name helps in avoiding some errors
  def infinite():Int= 1+infinite()

  def somefunction(x: => Int , y: => Int) = println(x)
  somefunction(36,infinite()) //this wont through error because of lazy evaluation
  //recursive functions is not loaded until function call inside the function
  //somefunction(infinite(),36) will throw error on running it
}
