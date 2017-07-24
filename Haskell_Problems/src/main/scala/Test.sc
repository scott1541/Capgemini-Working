import scala.collection._

val list1: List[Int] = List(6,3,9,1,2,5,8)
val list2: List[Int] = List(4,5,10,0,7,11,3)

val list3: List[(Int, Int)]= list1.zip(list2)
println(list3)

//list3.foreach(item => println(item.reduceLeft(_+_)))

println(list3.reduceLeft(_*_))

list3.reduceLeft((a,b) => a + b)
//a.reduceLeft( (a,b) => a + b )