package lectures.part2oop

object Objects extends App{
  //SCALA DOESN'T HAVE CLASS LEVEL FUNCTIONALITY
  //SCALA DOESN'T HAVE STATIC

  object Person {
    val nEyes = 2
    def canFly: Boolean = false

    //Factory method - their sole purpose is to create an instance of a person, to generate new instance
    // hence they are called factory methods. these are defined as 'apply'
    def apply(mother:Person, father:Person):Person = new Person("Bobby")
  }
  class Person(val name:String){

  }
  //Often we write classes and objects with same name in the same scope
  // this is to separate instance level functionality from static or class level functionality
  //this design of creating class and objects in the same scope are called COMPANIONS
  //By this design we can write all the code in either the regular instance or singleton instance in same file.
  //companions can access each others private members
  //scala is more oo than java


  println(Person.nEyes)
  println(Person.canFly)
  //Scala Objects are SINGLETON INSTANCE
  //i.e, its the only type and only instance
  val bobby = Person(new Person("mary"),new Person("john"))
  println(bobby.name)

  //SCALA APPLICATIONS ARE NOTHING BUT SCALA OBJECT WITH MAIN FUNCTION
  //IN OTHER WORDS PUBLIC STATIC VOID MAIN(STRING ARGS) IS TRANSLATED INTO
  //SCALA OBJECT WITH RETURN TYPE UNIT WITH ARGS ARRAY AS PARAMETER
  //def main (args:Array[String]):Unit
  //hence App has 'def main' method



}
