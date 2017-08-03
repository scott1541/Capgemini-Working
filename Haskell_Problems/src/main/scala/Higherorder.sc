//Currying
//A simple curried function, takes two separate arguments
def CurrFunc(a: Int)(b: Int): Int = {

  return a + b
}

//Returns function
CurrFunc(23) _

//Both return value
(CurrFunc(27) _).apply(34)

CurrFunc(34)(27)


//Apply Multiple
//Takes an input string and applies it multiple times

def ApplyTwice(text: String): String = text * 2
def ApplyThrice(text: String): String = text * 3

def ProcessText(input: String, function: String => String): Unit = {

  println(function(input))
}

ProcessText("Hello World", ApplyThrice)

ProcessText("Test", ApplyTwice)


val list1: List[Int] = List(6,3,9,1,2,5,8)
val list2: List[Int] = List(4,5,10,0,7,11,3)


//Zip with

//Takes two lists and applies function, in this case add or maximum
/*
def Add(list1: List[Int], list2: List[Int]): List[Int] = {
val list3: List[(Int, Int)]= list1.zip(list2)
println(list3)
//list3.foreach(item => println(item.reduceLeft(_+_)))
//println(list3.reduceLeft(_*_))
//list3.reduceLeft((a,b) => a + b)
//a.reduceLeft( (a,b) => a + b )
}
def Max()
def ZipWith(list1: List[Int], list2: List[Int], function: List[Int] => List[Int]): Unit = {
  println(function(list1, list2))
}
*/

//Map
//Add 3
val list = List(1,2,3,4,5,6,7,8,9,10,11,12)


list.map(x => x + 3) //res5: List[Int] = List(4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
list.map( x => x * 2)//res6: List[Int] = List(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24)

val listN = List(List(1,2,3), List(4,5,6), List(), List(7,8,9), List(10,11,12), List())
val inString = "CNnveRttHIsStrInG"
val inString2 = "eHeEgrLbsLOseWnORdsLdD"
//Filter
//Greater than 3
list.filter(x => x > 3)
//Equal to 3
list.filter(x => x == 3)
//Even numbers
list.filter(x => x % 2 ==0)
//Filter empty list elements
listN.filter(x => x != List())
//Filter out upper case
inString.filter(_.isLower)
//Filter out lower case
inString2.filter(_.isUpper)

//Quicksort with Filter
/*
def quickSortF(inpList: List[Int]): List[Int] = {
  inpList match {
    case inpList if(inpList.length <=1) => inpList
    case _ =>
        List.concat(
          quickSortF(inpList.filter( x => x >= (inpList(inpList.length/2)))),
          inpList.filter(x => x == (inpList(inpList.length/2))),
          quickSortF(inpList.filter( x => x <= (inpList(inpList.length/2)))))
  }
}
quickSortF(List(3,4,2,1,8,6,10,11,9))
*/
//Find all numbers 1-100000 divisible by 3829
(1 to 100000).filter(x => x % 3829 == 0)

//
(1 to 10000).map(x => x * x).takeWhile(x => !(x % 2 == 0) || x < 10000).sum
  //takeWhile(x => if(x %2 = 0){x * x})
