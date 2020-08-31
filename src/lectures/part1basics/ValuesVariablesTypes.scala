package lectures.part1basics

object ValuesVariablesTypes extends App{
  val x: Int = 42
  println(x)
  val aString: String = "hello"
  println(aString)
  val aShort: Short = 4883 //4bytes
  val aLong: Long = 5487458459845L //8bytes
  val aBoolean = true
  val aChar: Char = 'a'
  val aFloat: Float = 1.23f
  val aDouble: Double = 3.45455646
  // Vals are immutable

  //Variables

  var aIntVariable = 4
  aIntVariable = 5
  // variables can be reassigned. variables are used for side effects in functional programming
  // mostly vals are used in functional programming
}
