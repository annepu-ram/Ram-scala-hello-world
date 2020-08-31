package lectures.part3funcp

object TuplesAndMaps extends App{

  //############ TUPLES ##################

  // TUPLES are finite ordered lists
  val aTuple = new Tuple2(2, "Hello, Scala")
  //or
  val anotherTuple = (4, "hey there")
  // Tuples can go up to 22 because they can be used in conjunction with function types
  println(aTuple._1)
  println(aTuple.copy(_2 = "goodbye java")) // copy similar to case classes
  println(aTuple.swap)

  //############ MAPS ###################

  // Maps : Keys -> Value
  val aMap:Map[String,Int] = Map()
  val phonebook = Map(("rav",78990), "dan" -> 64387).withDefaultValue(-1)
  // -> is syntactic sugar for map (key value)

  println(phonebook.contains("rav"))
  println(phonebook("rav"))

  //if call phonebook with a key that doesnt exist it will throw an error
  //to solve this we can use .withDefaultValue()
  println(phonebook("NonKey"))


  //How to add new pairing
  val newPairing = "mary" -> 74784

  val newPhonebook =  phonebook + newPairing //we get newPhonebook because maps are immutable

  println(newPhonebook)

  // ############# Functions on Maps ################
  //map, flatMap, filter
  println(phonebook.map(tuple => tuple._1.toUpperCase -> tuple._2))
  println(phonebook.filter(pair => pair._2 % 2 != 0))

  //filterKeys
  println(phonebook.filterKeys( _.startsWith("r")))

  //mapValues
  println(phonebook.mapValues(values => values*10))

  //Conversions
  println(phonebook.toList)

  //Group By ###############
  val states = List("Andhra Pradesh","Telangana","Tamil Nadu","Karnataka","Kerala","Orissa","Goa","Arunachal","Assam")
  println(states.groupBy(state => state.charAt(0)))


  // ##### Exercises ###############################
  val phoneBook2 = Map("Jim"->56454,"JIM"->34359)
  println(phoneBook2.map(pair => pair._1.toLowerCase()->pair._2)) // Keys shouldn't overlap

  //Overly simplified social network example
  /*
  Person - string
  - add a person to network
  - remove a person
  - add a friend (mutual)
  - un-friend
  - number of friends
  - person with most friends
  - people with no friends
  - a social connection between two people direct or indirect
   */

  def add (network: Map[String, Set[String]], person:String): Map[String, Set[String]] =
  {
    network + (person -> Set())
  }

  def friend (network: Map[String, Set[String]], a:String, b:String): Map[String, Set[String]] =
  {
    val frnda = network(a)
    val frndb = network(b)
    network + (a -> (frnda + b)) + (b -> (frndb + a)) // if there is old pairing it will replace with new pairing in map with +
    // network.updated(a, frnda + b).updated(b, frndb + a)
  }

  def unfriend(network: Map[String, Set[String]], a:String, b:String):  Map[String, Set[String]] =
  {
    val frnda = network(a)
    val frndb = network(b)
    network + (a -> (frnda - b)) + (b -> (frndb - a))

  }
  def remove (network: Map[String, Set[String]], person:String): Map[String, Set[String]] =
  {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]):Map[String, Set[String]] =
    {
      if(friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc,friends.head,person))
      //else removeAux(friends - friends.head, unfriend(networkAcc,friends.head,person))
    }
    val unfriended = removeAux(network(person),network)
    unfriended - person

  }

  def nFriends(network:Map[String, Set[String]], person:String):Int =
    if(!network.contains(person)) 0
    else network(person).size

  def mostFriends(network:Map[String, Set[String]]):String ={
    network.maxBy(pair => pair._2.size)._1 //maxBy evaluates the maximum-value-characteristic of each pair in map and returns that pair
  }

  def noFriends(network:Map[String, Set[String]]):Map[String, Set[String]] ={
    network.filter(pair=> pair._2.size == 0)
  }

  def socialConnection(network: Map[String, Set[String]], a:String, b:String):Boolean =
    {
        def bfs(target:String,consideredPeople: Set[String], discoveredPeople: Set[String]):Boolean ={
          if (discoveredPeople.isEmpty) false
          else{
            val person = discoveredPeople.head
            if (person ==  target) true
            else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
            else bfs(target, consideredPeople+person, discoveredPeople.tail ++ network(person))
          }
        }
      bfs(b,Set(),network(a)+a)
    }

  val empty:Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"),"Mary")
  println(network)
  println(friend(network,"Bob","Mary"))
  println(unfriend(friend(network,"Bob","Mary"),"Bob","Mary"))

  val people = add(add(add(empty,"Bob"),"Mary"),"Jim")
  val jimBob = friend(people,"Bob","Jim")
  val testNet = friend(jimBob,"Bob","Mary")
  val testNet2 = add(testNet,"Dan")
  println(noFriends(testNet2))


  //println()
  //def

}


