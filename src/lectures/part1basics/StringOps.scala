package lectures.part1basics

object StringOps extends App {
  val aString:String = "Hello, I am learning Scala"
  println(aString.charAt(2))
  println(aString.substring(3,10))
  println(aString.split(" ").toList)
  println(aString.startsWith("Hello"))
  println(aString.replace(" ","-"))
  println(aString.toLowerCase())
  println(aString.length)

  //scala specific utility functions
  val aNumberStr ="2"
  val aNumber = aNumberStr.toInt
  println("hey" +: aNumberStr :+ "there") //prepending or appending in scala
  println("hello there".reverse)
  println("hello".take(2))

  //scala specific string interpolators
  //s-interpolator
  val name = "Ram"
  val age = 27
  val speed = 1.2f
  val aStr = s"Hello this is $name and age is $age"
  val aStrInterpltnExprsn = s"Hello this is $name and age is ${age+1}"
  println(aStrInterpltnExprsn)

  //f-interpolator
  //f interpolator for formatted output
  val fStr = f"$name%s's car cover $speed%2.2f kms/min"
  println(fStr)
  //f states formatted interpolated string
  //%s states its a string format
  //2.2f minimum two characters with 2 decimal precision

  //raw-interpolator
  println(raw"a raw \n string")
}
