package lectures.part2oop

object AbstractDataTypes extends App{

  abstract class Animal{
    val creatureType: String  //since we are not assigning a value it is abstract type
    def eat:String            //abstract method doesn't have method definition
    //abstract class cannot be instantiated
    val anotherNonAbstractVal = "hey"

    //abstract classes can have both abstract and non abstract members

  }

  class Dog extends Animal
  {
    override val creatureType: String = "canine"  //override keyword is not mandatory
    override def eat: String = {
     s"crunch, crunch"
    }
  }

  //Traits
  //ultimate abstract data types in scala
  trait Carnivore {
    def eat(animal: Animal): Unit
    val nonabstractMemberMeal:String = "meat"

  }
  //Traits can be extended along with the classes
  trait coldblooded
  class Crocodile extends Animal with Carnivore with coldblooded {
    val creatureType = "crocodile"
    def eat :String = "nomnomnom"
    def eat(animal:Animal) = println(s"I'm a crock and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  println(croc.eat(dog))


  //traits vs abstract classes
  //1- traits cannot have constructors parameters
  //2- a class can have multiple parents traits, but cant extend multiple abstract classes
  //3- traits are behaviour
  //4- abstract class is a type like class of entity

}
