package lectures.part4patternMatching

 object PatternsEverywhere extends App{
   // big idea #1
   try {

   }
   catch {
     case e: RuntimeException => "runtime"
     case npe:NullPointerException => "null"
     case _ => "something"
   }

   //catches are actually matches
   /*
   try {

   }
   catch (e) {
   e match {
       case e: RuntimeException => "runtime"
       case npe:NullPointerException => "null"
       case _ => "something"
       }
   }
    */

   // big idea #2
   val list = List(1,2,3,4)
   val evenOnes = for{
     x <- list if x%2==0
   } yield x*10
   //generators are also based on pattern matching
   //see following example and see how its decomposed similar to pattern matching
   val tuples = List((1,2),(3,4))
   val filterTuples = for{
     (first,second) <- tuples
   } yield first*second

   // big idea #3
   val tuple1 = (1,2,3)
   val(a,b,c) = tuple1
   //this done by name binding property of pattern matching
   //another example
   val head :: tail = list
   println(head)
   println(tail)

   // big idea #4
   //partial functions
   val mappedList = list.map{
     case v if v % 2 == 0 => s"$v is even"
     case 1 => "the one"
     case _ => "something else"

   } //partial function literal

   //which is same as ----
   val mappedList2 = list.map{ x => x match {
       case v if v % 2 == 0 => s"$v is even"
       case 1 => "the one"
       case _ => "something else"
     }
   }
   println(mappedList)

 }
