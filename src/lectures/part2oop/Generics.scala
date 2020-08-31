package lectures.part2oop

object Generics extends App{
  //type parameterization of classes and methods
  //generics are used to make use of functionality on different types of data
  //say a generic class functionality can be used for both int and float
  //Collections are powerful use case of generics
  //like in c# List<persons> list of persons

  class MyList[A]{

  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //even traits can be type parameterised
  //object cannot be type parameterized
  object MyList {
    def empty[A]:MyList[A] = ???
  } //companion object

  val emptyList = MyList.empty[Int]

  trait structTrait[key, Value] // multi type parameters


  ///////////////////////////////
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  //Variance Problem
  //Q variance if B extends A should List of B extend A
  //1. yes, List[cats] extends List[Animal] = COVARIANCE //list[animal] can hold cat objects
  class CovariantList[+A]
  val animal:Animal = new Cat
  val animalList:CovariantList[Animal] = new CovariantList[Cat]

  //2. No, = Invariance // Animal list should only hold Animal objects
  class InvariantList[A]
  val invariantList:InvariantList[Animal] = new InvariantList[Animal]

  //3. Hell, no! CONTRAVARIANT
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types - upper bounded type
  class CageSub[A<:Animal](animal:A) // A accepts only sub type classes of Animal
  val cageSub = new CageSub(new Dog)
  class CageSuper[A>:Animal](animal:A) // A accepts only super type classes of Animal
  val cageSuper = new CageSuper(new Dog)

  //class car
  //val cage = new Cage(new Car) => throws error


}
