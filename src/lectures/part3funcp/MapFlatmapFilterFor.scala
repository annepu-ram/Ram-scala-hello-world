package lectures.part3funcp

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3) //official collections
  println(list.head)
  println(list.tail)

  //map
  val plusOne = (n:Int) => n+1

  println(list.map(plusOne))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_%2==0))

  //flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val numbers = List(1,2,3,4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("Black","White")

  val func =   (x:Int) => (y:Char) => y+x.toString()

  println(numbers.flatMap((x:Int) => chars.map(_+x.toString())))
  // or
  println(numbers.flatMap((x:Int) => chars.map(func(x))))

  val combinations = numbers.flatMap((x:Int) => chars.flatMap( (c: Char) => colors.map((color: String) => ""+c+x+color)))
  println(combinations)

  list.foreach(x=>println(x))


//for-comprehensions are readable code
  //compiler rewrites for comprehensions into map flat-map and filter
  //above function can be rewritten like below
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield ""+c + n + color
  println(forCombinations)

  //for-comprehensions with side effects
  for {
    n <- numbers
  } print(n)
  println()

  //syntax overload
  val newList = list.map {
    x => x * 2
  }
  println(newList)

  //for for comprehensions to work type signature of map flatmap and filter should in the following way
  /*
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: ((A) => Boolean)): MyList[A]
   */
}
