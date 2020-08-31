package lectures.part4patternMatching
//package exercisesFunctional.MyList_Functional

import exercisesFunctional.MyList_Functional.{Cons, Empty, MyList}

object AllThePatterns extends App{

   //1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "A number"
    case true => "The truth"
    case "scala" => "The scala"
    case AllThePatterns => "singleton object"

  }

  //2 - match anything
  // 2.1 wildcard
  val matchAnything = x match {
    case _ => s"match anything"
  }

  //2.2 variable
  val variableMatching = x match{
    case something => s"print that $something"
  }

  //3 - tuples
  val aTuple = (1,2)
  val tupleMatch = aTuple match {
    case (1,1) => s"its a match"
    case(something,2) => s"it has got $something"
  }

  val nestedTuple = (1,(1,2))
  val matchNestedTuple = nestedTuple match{
    case (_,(2,v)) =>
  }
  //PMs can be nested

  // 4- case classes constructor pattern
  //PMs can be nested with case classes also
  val aList:MyList[Int] = Cons(1,Cons(1,Empty))
  val matchAList =  aList match{
    case Empty =>
    case Cons(head,Cons(subhead,subtail)) =>
  }

  //5 - list patterns
  val aStandardList = List(1,2,3,42)
  val standardMatching = aStandardList match {
    case List(1, _, _, _) => //extractor
    case List(1, _*) => //list of arbitrary length
    case 1 :: List(_) => //infix pattern
    case List(1,2,3) :+ 42 => //infix pattern
  }

  //6 - type specific pattern matching
  val unknown:Any =2
  val unknowMatch = unknown match{
    case list:List[Int] => //explicit type specifier
    case _ =>
  }

  //7 - name binding
  val nameBindingMatch = aList match{
    case nonEmptyList @ Cons(_, _) => //name binding => use the name later (here)
    case Cons(1, rest @ Cons(2, _)) => //name binding inside nested patterns
  }

  // 8 - multi-patterns
  val multiPattern =  aList match{
    case Empty | Cons(0, _) =>
  }

  // 9 - if guards
  val secondElementTest =  aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
  }

  //coz of jvm issue
  //pattern matching cannot do generic type matching
  //cant differentiate between List[Int], List[String]
}
