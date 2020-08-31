package lectures.part2oop

object AnonymousClasses extends App{
 abstract class Animal{
   def eat: Unit
 }
  //anonymous class
  val funnyAnimal = new Animal {
    def eat:Unit = println("hahaha")
  }
  /*
  What the compiler does when we create a class while instantiating like above
  this is what happens
  compiler creates a anonymous class like
  class AnonymousClasses$$anon$1 extends Animal{
    def eat : Unit println("hahaha")
  }
  val funnyAnimal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass())
  //prints class lectures.part2oop.AnonymousClasses$$anon$1
}
//________Final Note________________
//anonymous instantiation works for abstract classes traits and non abstract classes
//for abstract classes define abstract methods inside the anonymous classes
