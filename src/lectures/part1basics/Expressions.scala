package lectures.part1basics

object Expressions extends App{

  val x = 1+2; //Expression
  println(x)
  println(!(1==true))
  var aVariable:Int = 2
  aVariable +=1
  println(aVariable)

  // Expression vs Instruction
  // Expressions evaluate to a result and Instruction instructs computer to do something
  // Scala uses If expression In python we use IF instruction

  val aBool = true
  println(if(aBool) 3 else 1)

  // instructions are executed (Java) and expressions are evaluated (Scala)
  //There are loops in scala but they are discouraged from using in functional programming because they are imperative
  //scala forces everything to be an expression. Only definition or import statements are are not expressions

  val aInstructionVal = (aVariable = 5)
  // reassigning variables are a side effect and side effect in scala are actually expressions returning unit
  //aInstructionVal is Unit or () or (void in other languages - no return)
  println(aInstructionVal)


  var i=0
  val anotherInstVal = while (i<10){
    i += 1
    print(i)
  }

  println(anotherInstVal)
  // Examples of side effects are println(), while(), reassigning
  // they are expressions returning unit
  // they are instructions in other languages but they are still a expression in scala returning unit

  //code blocks
  val aCodeBlock = {
    val x = 2
    val y = 3
    if (x>y) "x>y" else "x is not greater than y"
    //values defines inside a code block have scope of the code block.
  }
  println(aCodeBlock)
  //code blocks are expressions, if you hover over code block you will find the value as string coz the final statement is evaluated as string

}
