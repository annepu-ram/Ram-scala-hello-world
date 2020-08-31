package lectures.part1basics

object TypeInference extends App{
    // compiler auto infers type of the variable by evaluating thr right hand side of the expression
  val a:Int =4
  val inferString = a+" another string" //right hand side is string so infers the entire expression as string
  println(inferString)
  def someFunc()=
    "string"
  println(someFunc())
  //scala compiler can also infer return type of some functions
  //but it can infer return type of recursive function


}

