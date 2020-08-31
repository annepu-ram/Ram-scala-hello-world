package lectures.part4patternMatching

import scala.util.Random

object PatternMatching extends App {
    // switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the One"
    case 2 => "double or nothing"
    case 3 => "third is a charm"
    case _ => "something else"

  }
  println(x)
  println(description)

  case class Person(name: String, age: Int)
  val bob = Person("bob",20)

  val greeting = bob match {
    case Person(a, n) if n < 20 => s"Hi my  name is $a and age is $n, cant drink"
    case Person(a, n) => s"Hi my  name is $a and age is $n"
    case _ => "don't know what it is"
  }

  print(greeting)

  /*
  1. cases are matched in order
  2. throws exception MatchError if it doesn't any case
  3. return type is unified type of all the types in all the cases

   */
  //PM on sealed class hierarchy
  sealed class Animal
  case class Dog(breed:String) extends Animal
  case class Parrot(greeting:String) extends Animal

  val animal:Animal = Dog("TERRA NOVA")

  animal match {
    case Dog(somebreed) => println (s"the breed of dog is $somebreed")
  }
  //this throws a warning saying pattern matching is not exhaustive ... because  it doesn't cover parrot class
  //hence sealed classes helps us cover our bases

  //don't use pattern matching for if conditions that's an overkill

  //EXERCISES
  trait Expr
  case class Number(n:Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr


  //get human readable expr from these exprs
  //prod(Sum(a,b),c) should show (a+b)*c
  //sum(prod(number(a),number(b)),number(c)) should show a * b + c
  //sum(number(a),number(b),number(c)) a+b+c

  def show(e:Expr):String=e match {
    case Number(n) => s"$n"
    case Sum(e1,e2) => show(e1) +" + "+ show(e2)
    case Prod(e1,e2) => {
      def maybeParenthesis(exp:Expr) = exp match{
        case Prod(_,_) => show(exp)
        case Number(_) => show(exp)
        case _ => "( "+show(exp)+" )"
      }
      maybeParenthesis(e1) + " * " + maybeParenthesis(e2)
    }

  }

  println(show(Prod(Sum(Number(3),Number(2)), Number(3))))
  println(show(Sum(Sum(Number(3),Number(2)), Number(3))))
  println(show(Sum(Number(3),Number(2))))
  println(show(Sum(Prod(Number(3),Number(2)), Number(3))))









}
