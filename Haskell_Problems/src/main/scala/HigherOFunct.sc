
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


var list1: List[Int] = List(1,4,7,9,11,13,15)
var list2: List[Int] = List(2,3,6,8,12,10,17)
//Zip with
//Takes two lists and applies function, in this case add or maximum
def Add(list1: List[Int], list2: List[Int]): List[Int] = {list1.zipAll(list2,0,0).foreach(
  case(a,b) => )
  case _ => }
def Max()

def ZipWith(list1: List[Int], list2: List[Int], function: List[Int] => List[Int]): Unit = {

  println(function(list1, list2))
}

//Map
val list = List(1,2,3,4,5,6,7,8,9,10,11,12)
