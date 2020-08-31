package lectures.part3funcp

object HOFsCurries extends App {
  //HOFs higher order functions might take a function as a parameter or return a function as output
  // examples map, flatMap, filter
  val superFunction:(Int,(String,(Int => Boolean))=>Int) => (Int => Int) = null

  //A function that applies n times over a value x *******************************
  //nTimes(f, n, x)
  //=> f(f(.....f(x)..))

  val nTimes:(((Int => Int), Int, Int) =>Int) = new (((Int => Int), Int, Int) =>Int) {
    def apply(f: (Int => Int), n: Int, x: Int): Int =
      if (n <= 0) x
      else
        nTimes(f, n - 1, f(x))
  }

  val plusOne:(Int=>Int)=(x:Int)=>x+1

  println(nTimes(plusOne,5,5))

  val nTimesBetter:(Int=>Int, Int) =>(Int=>Int) = (f:Int=>Int, n:Int) => {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))
  }

  val multipleMultiplier = nTimesBetter(_*2,5)
  // 1st iter ntimeBetter

  println(multipleMultiplier(2))

  //curried functions
  val superAdder :Int => Int =>Int = (x:Int) => (y:Int) => x+y
  println(superAdder(7)(9))

  //passing multiple lists of parameters = CURRYING
  def curriedFormatter(c:String)(x:Double)=c.format(x)

  val specialFormatter:(Double=>String) = curriedFormatter("%4.2f") //returns a function
  val preciseFormatter:(Double=>String) = curriedFormatter("%2.8f")

  println(specialFormatter(math.Pi))
  println(preciseFormatter(math.Pi))

  //Exercises

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = {
    x => y=> f(x,y)
  }

  def fromCurry(f: Int => Int => Int): (Int, Int) => Int = {
    (x,y)=>f(x)(y)
  }

  def compose[A, B, T](f: A => B, g: T => A): T => B = {
    x => f(g(x))
  }

  def andThen[A, B, C](f: A => B, g: B => C): A => C = {
    x => g(f(x))
  }

  def superAdder3 = toCurry( _ + _ )
  def add4 = superAdder3(4)
  println("add4 result: "+ add4(21))

  val simpleAdder = fromCurry((x:Int) => (y:Int) => x+y)
  println("fromCurry: "+simpleAdder(4,16))

  val add2 = (x:Int)=> x+2
  val times3 = (x:Int)=> x*3

  val composedFunc =  compose(add2, times3)
  val orderedFunc = andThen(add2, times3)

  println(composedFunc(4))
  println(orderedFunc(4))
}
