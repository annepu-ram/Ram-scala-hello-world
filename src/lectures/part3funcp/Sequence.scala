package lectures.part3funcp

import scala.util.Random

object Sequence extends App {

  // ######## SEQ ##################
  // facilitate with indexing
  // have well defined order
  // support various operations -  apply, iterator, length etc for indexing, concatenation and iterating
  /*
  trait Seq[+A]{
    def head: A
    def tail: Seq[A]
  }
   */
  val aSequence = Seq(1,2,3,4,5,6)
  println(aSequence)
  //actually the seq class has a apply method that can construct objects of sub-classes of seq
  // hence above aSequence is a list because declaring with a seq class constructs a list object
  println(aSequence.reverse)
  println(aSequence(2)) //seq.get(2)
  println(aSequence ++ Seq(7,8))
  println(Seq(5,1,6,3,9).sorted)

  //########### RANGES ###############

  val aRange:Seq[Int] = 1 to 10 // and 1 until 10 (10 not inclusive)
  // aRange.foreach(println)
  (1 to 10).foreach(x=> println(x))


  // ####### LISTS ##################
  /*
  Sealed abstract class List[+A]
  case object Nil extends List[Nothing]
  case class ::[A](val hd: A, val tl: List[A]) extends List[A]
   */

  // Lists are LinearSeq immutable linked lists
  // head tail isEmpty are fast
  // accessing middle elements have linear time complexity
  // sealed class has two sub types Nil and ::

  val aList = List(1,2,3,4)
  val prepended = 42 :: aList
  println(prepended)
  val prependedNAppended = 42 +: aList :+ 46
  println(prependedNAppended)
  val listOf5Apples = List.fill(5)("Apples")
  println(listOf5Apples)
  println(aList.mkString("-")) // Converts to a string with "-" as separator


  // ############ ARRAYS ###############
  // equivalent of java arrays and can be defined with pre-allocated space
  // manually constructed with predefined lengths
  // mutable
  // interoperable with java's T[] arrays
  // indexing is fast and any element can be accessed in constant time

  /*
  final class Array[T]
    extends java.io.Serializable
    with java.lang.Cloneable
   */

  val arrNumbers = Array(1,2,3,4,5)
  val threeElements = Array.ofDim[Int](3)
  threeElements.foreach(println)
  // Primitive types have default values such as zero or false but reference types like strings its null
  Array.ofDim[String](2).foreach(println)
  arrNumbers(3)=0 //sets 4th element as 0 by calling number.update(3, 0) // only used for mutable collections

  // arrays and seq
  val seqNumbers: Seq[Int] = arrNumbers // IMPLICIT CONVERSION OF ARRAY TO SEQUENCE
  println(seqNumbers) //We get a WrapedArray


  // ########### VECTORS #################
  // default implementation for immutable sequences
  // fast element addition and retrieval
  // constant (indexed) read and write
  // implemented as fixed branch size
  // good performance for very large size

  /*
  final Vector[+A]
   */
  //val aVector:Vector[Int] = Vector(1,2,3,4,5,6)


  // Performance of Vector vs List

  val maxRuns = 10000
  val maxCapacity = 100000

  def perfTest(collectn: Seq[Int]): Double= {

      val r = new Random()

      val times = for {
        i <- 1 to maxRuns
      } yield {
        val currentTime = System.nanoTime()
        collectn.updated(r.nextInt(maxCapacity), 2) //updated method is available for all sequences and returns a new sequence
        // whereas update  method is only available for mutable sequence and makes update in place
        System.nanoTime() - currentTime
      }

    times.sum * 1.0/maxCapacity
  }
  //Takes time to update middle element
  println( perfTest(   (1 to maxCapacity).toList   ))
  //takes less time to update middle element but replaces entire 32 piece tree
  println( perfTest(   (1 to maxCapacity).toVector   ))

  // You see vectors are very fast hence they are default sequences



}
