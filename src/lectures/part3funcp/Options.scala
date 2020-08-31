package lectures.part3funcp

import scala.util.Random

object Options extends App {

  // Options is a wrapper for a value that might be present or not
  /*
  sealed abstract class Option[+A]
  case class some[+A](x:A) extends Option[+A]    //Some wraps concrete value
  case object None extends Option[Nothing]       //None is a singleton for absent value
   */

  // Options mean possible absence of a value
  //Options are present in many places in scala standard library
  //
  //Maps use options on its basic get operation; prefer it over apply
  val map = Map("key"->"value")
  println(map.get("other")) //None
  //In essence options are used to avoid null pointer exceptions
  //During  application of filter  on list we  might get an option as output if none of the elements match the filter condition

  val firstOption: Option[Int] = Some(4)
  val noOption:Option[Int]= None
  println(firstOption)


  // Options can be used with unsafe API
  def unsafeMethod():String = null

  // Backup API
  def backupMethod: String = "valid backup"
  //val result  = Some(unsafeMethod()) // Wrong
  val result1 = Option(unsafeMethod()).orElse(Option(backupMethod))


  //Design better Unsafe APIs with options //Options can be used handle null values elegantly
  def betterUnsafeMethod():Option[String] = None
  def betterBackupMethod():Option[String] = Some("valid string")

  val result2 = betterUnsafeMethod() orElse betterBackupMethod()
  println(result2)

  //Functions on Options
  println(firstOption.isEmpty)
  println(firstOption.get) //Don't use it - UNSAFE //o/p 4
  // we have map, flat-map, filter
  println(firstOption.flatMap(x => Option(x*10))) //Some(40)


  /*
  Exercises
   */

  println("exercises o/p")

  val config: Map[String, String] = Map(
    //Fetched from elsewhere //usually from config file or another api // which might or might not be there
    "host" -> "176.45.6.1",
    "port" -> "80"
  )

  class Connection {
    def connect = {
      "connected"
    }
  }
  object Connection {
      val random = new Random()

      def apply(host:String, port:String):Option[Connection]={  //Safe connection // connection might not be there
        if (random.nextBoolean()) Some(new Connection)
        else None
      }
    }

    //try to connect with these uncertainties

    val host = config.get("host")
    val port = config.get("port")
  /*
  if(h!=null)
    if(p!=null)
      return Connection(h, p)
  return null
   */

    val connection2 = host.flatMap(h => port.flatMap(p => Connection(h, p)))

    /*
    if(connection2 != null)
      return connection2.connect
    return null
     */

    val connectionStatus = connection2.map(c => c.connect)

    println(connectionStatus)  //here we get none or 'some' object

  /*
  if(connectionStatus != null)
    println(connectionStatus)
   */
    connectionStatus.foreach(println) //prints connected only if connected

  //chaining all statements
  config.get("host")
    .flatMap( h => config.get("port")
      .flatMap( p => Connection(h, p)))
    .map(c => c.connect)
    .foreach(println)

  //for comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect

  forConnectionStatus.foreach(println)

  }




