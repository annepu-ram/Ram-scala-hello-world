package lectures.part2oop

import playground.{Cinderalla => Princess, PrinceCharming} // to import multiple classes
//=> to rename imports => aliasing
import playground._ //to import all file in that package


object PackagingAndImports {
  //package members are directly accessible with simple names
  val writer = new Author("Ram","Annepu",2020)

  //Import package - other package members should be imported when used in different package
  val princess = new Princess()
  //or
  //val princess = new playground.Cinderalla()

  //Packages are ordered in hierarchy

  //package object is very scala specific
  //they are used for universal objects or constants for a specific package
  println(pi)
  val prince = new PrinceCharming

  //Default Imports concept - these are basic packages that by default imported by compiler without explicit import
  //java.lang - contains string object
  //scala - Int, Nothing, Function
  //scala.Predef - println, ???
}
