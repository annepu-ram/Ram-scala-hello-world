package lectures.part2oop

object Inheritance extends App {

  class Animal { //super class
    /*protected*/ def eat = println("eat, eat")
    //private access modifier restricts the usage to this class only not even child classes can access it.
  }

  //scala offers single class inheritance i.e, we can only inherit one class at a time
  class Cat extends Animal{ // sub-class
    def crunch = {
      eat
    }
  }

  val cat = new Cat
  cat.crunch
  // we cant call eat in this scope. only the sub class or the child class can call eat method inside it

  //Inheritance and Constructors
  class Person (name:String, age:Int){
    def this(name:String) = this(name, 0) //constructor overload
  }
  class Adult(name:String, age:Int, IdCard: String) extends Person(name, age)
  //according to jvm rule the constructor of super class should be called before the constructor of child class

  //method override  and variable override in child class
  //also if you observe the method in child class is made public from protected hence it is can be accessed outside the child class.
  //override can also be used with variables of super class with 'override val x'
  class Dog extends Animal{
    override def eat: Unit = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog
  println(dog.eat)

  //type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog //animal can hold any sub class instance

  unknownAnimal.eat
  //this will print eat under dog class because a method call will run the most overriden version method

  //REMEMBER THE DIFFERENCE BETWEEN
  //overriding vs overloading
  //overriding is change of implementation of method of super class in child class
  //overloading is different method signatures with same method name.


  //Limiting override
  //final is one method to prevent overriding
  //final can be used on class also
  //final classes cannot be extended
  //string class is final and int too

  //seal a class
  //sealing a class makes a class extendable in the same file but not in another file.



}
