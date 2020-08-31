package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John",26)
  println(person.age)
  person.greet("Jerry")


  val author = new Author("john","newman",1980)
  val novel = new Novel("love me again",1999,author)
  println(author.fullName())
  println(novel.authorAge())
  println(novel.isWrittenBy())
  val novel_re_release = novel.copy(2001)
  println(novel_re_release.authorAge())
  println(novel_re_release.isWrittenBy())

  val counter = new Counter(2)
  println(counter.increment().currentCount())
  println(counter.decrement(2).currentCount())
  println(counter.increment(2).currentCount())
  println(counter.decrement().currentCount())
  println(counter.increment().decrement(2).increment(2).decrement().currentCount())
  println(counter.increment().decrement(2).increment(2).currentCount())
}

class Person(name:String, val age:Int = 0) //constructor //name parameter, age is field
{
  val x=2

  println(x+2)
  //method
  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")
  //overloading
  //overloading is having same method names but with different signatures
  def greet() = println(s"Hi, I am $name")
  //def greet():Int = 2  => throws error

  //overloading cannot be done with methods with same parameters but with different return types
  //overloading means different number of parameters or/and different types or/and different return types

  //#############################
  //overloading constructors or multiple constructors

  def this (name:String) = this(name, 0)
  //auxiliary constructor calling main constructor with name field and age as zero

  def this() = this("John Doe") //calling sec
  //hence auxiliary constructors are useless because they can only be used to call
  //-default or other auxiliary constructors as above
  //which can also be done by passing default value in the class definition as shown above

}
//class organises data and behaviour i.e code
//instantiation means concrete realisations in memory that can for the data structure in the memory

//class parameters are not fields
//name is class parameter and age is class field so field can be accessed with dot
//whereas parameters can be used only inside the classes
//use val before parameters to define them as class fields

//class block can contain anything
//also class block are evaluated on instantiation
//so on every instantiation println(x+2) is evaluated and printed as 4

// this is used to refer to instance field (but its not a class field but it is still available)


///////EXERCISES

/*
Novel and writer
writer first name, surname, year of birth
 method fullname

Novel name, year of release, author
 methods authorAge -age of author at year of release
         isWrittenBy(author)
         copy(new year of release) returns new instance of novel with new year

 */

class Author(val firstName: String, val surname: String, val yearOfBirth: Int){

  def fullName():String=
    s"author name is $firstName ${this.surname}"

}
class Novel(val name : String, val yearOfRelease :Int, val author:Author){
  def authorAge():Int = {
    this.yearOfRelease - author.yearOfBirth
  }
  def isWrittenBy():String={
    s"${author.firstName} ${author.surname}"
  }
  def copy(yearOfRelease:Int):Novel ={
    new Novel(this.name, yearOfRelease, this.author)
  }
}
class Counter(val value:Int){
  def currentCount():Int =
  value
  def increment():Counter =
  new Counter(value+1)   //immutability , which says instances are constant similar to vals concept, whenever we need to modify a instance we create a new instance
  def decrement():Counter =
    new Counter(value-1)
  //def increment(increaseBy:Int):Counter =     //overloading methods
  //  new Counter(value+increaseBy)
  //def decrement(decreaseBy:Int):Counter =     //overloading methods
  //  new Counter(value-decreaseBy)
  def increment(increaseBy:Int): Counter =
    if (increaseBy<1) this
    else increment.increment(increaseBy - 1)
  def decrement(decreaseBy:Int): Counter =
    if (decreaseBy<1) this
    else decrement.decrement(decreaseBy - 1)
}
//immutability , which says instances are constant similar to vals concept, whenever we need to modify a instance we create a new instance