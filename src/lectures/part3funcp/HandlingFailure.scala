package lectures.part3funcp
import lectures.part3funcp.Options.Connection

import scala.util
import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App{
  /*
  sealed abstract class Try[+T]
  case class Failure[+T](t : Throwable) extends Try[T]
  case class success[+T](value : T) extends Try[T]
   */

  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Super Failure"))
  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("No String")

  val potentialFailure = Try(unsafeMethod)
  println(potentialFailure)
  //In this example try catches the runtime exceptions and wraps it up in Failure Object and takes care of exception without crashing

  //Syntactic sugar for above try class
  val anotherPotentialFailure = Try {
    unsafeMethod()
  }

  //Utilities
  println(potentialFailure.isSuccess)

  //orElse //Using unsafe apis
  def backupMethod():String = "returned string"
  val fallbackTry = Try(unsafeMethod()) orElse Try(backupMethod())
  println(fallbackTry)

  //Define an API with better error handling
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException("Error Error Error"))
  def betterBackUpMethod(): Try[String] = Success("A valid result")

  val betterAPIResult = betterUnsafeMethod() orElse betterBackUpMethod()

  //BY NOW WE SHOULD HAVE ANALOGY WITH OPTIONS
  //WHENEVER CODE A PIECE OF CODE CAN HAVE NULLS USE OPTION type data
  //WHENEVER CODE CAN THROW EXCEPTIONS USE TRY type date

  //TRY type also has map, flatMap, filter
  println(aSuccess.map(_*2))
  println(aSuccess.filter(_>10))  //this turns a success into a failure and failure will contains an exception


  //EXERCISES
  
  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String)=println(page)
  class Connection{
    def get(url: String)={
      val random = new Random(System.nanoTime())
      if(random.nextBoolean()) "<HTML>.....</HTML>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url:String):Try[String] = Try(get(url))   ///Wrapping above method with try makes it a safe api that doesn't blow up with exception
  }

  object HttpService{
    val random = new Random(System.nanoTime())
    def getConnection(host: String, port: String):Connection ={
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else using port")

    }
    def getSafeConnection(host: String, port: String):Try[Connection] = Try(getConnection(host, port))
  }

  val possibleConnection = HttpService.getSafeConnection(hostname,port)
  val possibleHtml = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHtml.foreach(renderHTML)

  //Shorthand version
  HttpService
    .getSafeConnection(hostname,port).flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  for{
    connection <- HttpService.getSafeConnection(hostname,port)
    html <- connection.getSafe("/home")
  } renderHTML(html)


  /*
  IMPERATIVE LANGUAGE CONSTRUCT

  try{
    connection = Http.service(hostname,port)
    try{
      page = connection.get("/home")
      renderHTML(page)
    }
    catch (some other exception){

    }

  }
  catch(exception){

  }

  /// All this clumsiness of multiple nested 'try's is avoided in scala
  // WE AVOID ENDLESS SPAGATIE CODE OF TRY in SCALA
   */



}

