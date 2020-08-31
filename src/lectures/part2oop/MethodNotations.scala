package lectures.part2oop

object MethodNotations extends App {
  class Person(val name: String,val favoriteMovie:String, val age:Int = 21){
    def likes(movie:String):Boolean = movie==favoriteMovie
    //def +(name:String):String = s"$name and ${this.name}"
    def + (name:String):Person = new Person(name, this.favoriteMovie, this.age)
    def unary_! : String = s"$name, this is unary operator example"
    def unary_+ = new Person(this.name,this.favoriteMovie, this.age+1)
    def isAlive () : Boolean = true
    def learns(subject:String) = s"${this.name} learns $subject"
    def learnsScala = this.learns("Scala")
    def apply(text : String) = s"this method is directly applied when we call the actual instance of this method and here is $text"
    def apply(times:Int) =  s"${this.name} watched ${this.favoriteMovie} $times times"
  }
  val sal = new Person("Sal","Shakespeare In Love")
  println(sal.likes("Inception")) //or

  //Infix notation = operator notation (syntactic sugar)
  println(sal likes "Inception")

          // Here likes acts like an operator // cool and important
          //hence methods can take any symbol
  println(sal + "Jal")
          //hence all the operators are methods
          //which we can test by taking 1. and checking all the methods ctrl + space to check all methods for that class instance
  println(1.+(4)) //because + is a method of 1 or int
  //akka actors have ! and ?

  //Prefix notation
  val x = -1
  //is equivalent to
  println(x, 1.unary_-)
  //both are same
  println(!sal)
  //Unary can be used with only ! ~ + -

  //Postfix //it has no parameters other than that its just infix notation
  println (sal isAlive)

  //apply // A very special method , very very special

  println(sal.apply("some text"))
  // above method can be called like
  println(sal("some text"))

  println((sal + "another nick name for sal").name)
  //over loading and infix combined

  println(+sal.age)
  //over loading and unary operator

  println(sal learnsScala)

  println(sal(2))

}
