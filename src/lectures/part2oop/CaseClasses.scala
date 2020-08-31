package lectures.part2oop


//often for light weight data structures like class person we need to implement boiler plate like companion objects,
// equals, hashCode, apply and toString methods
object CaseClasses extends App {

  case class Person (name:String,age:Int)

  //1.case classes promote all class parameters to fields
  val person = new Person("JohnDoe",34)
  println(person.age)

  //2. sensible toString
  println(person.toString())
  //or
  println(person)

  //3. equals and hashCode are defined out of the box for case classes
  val newPerson = new Person("JohnDoe",34)
  println(person == newPerson)

  //4. case classes have handy copy methods
  val newNewPerson  =  person.copy(age =30)
  println(newNewPerson)

  //5. case classes have companion objects
  val thePerson = Person("JohnDoe",45) //this calls companion object's apply method and that method directly returns
  // person instance without new keyword

  //6. case classes are serializable
  //Akka sends serializable data

  //7. case classes have extractor patterns i.e, they can be used for pattern matching

  //case objects have all the case classes features except companion objects

  case object UnitedKingdom {
    def name: String = "UK"
  }
}