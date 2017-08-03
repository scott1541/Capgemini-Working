//16 Drop every nth element
def drop[T](dropNum: Int, inpList: List[T]): List[T] = {
  inpList match {
    case Nil => Nil
    case head :: tail if(inpList.length % dropNum == 0) => drop(dropNum, tail)
    case head :: tail => head :: drop(dropNum, tail)
  }
}

drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))


//17 Split a list into two parts
//Uses inbuilt splitAt function...
//Could be done recursively, but little point if splitAt works

def split[T](splitNum: Int, inpList: List[T]): (List[T], List[T]) = {
  inpList.splitAt(splitNum)
}
split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))


//18 Slice
//Again, uses inbuilt function

def slice[T](slStart: Int, slEnd: Int, inpList: List[T]): List[T] = {
  inpList.slice(slStart, slEnd)
}

slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))


//19 Rotate a list N places to left
//Splits list at n and swaps front and rear
//If number is neg, add length of array to it

def rotate[T](rotBy: Int, inpList: List[T]): List[T] = {
  rotBy match {
    case rotBy if(rotBy > 0) => val (front, rear) = inpList.splitAt(rotBy)
                   rear ::: front
    case rotBy if(rotBy < 0) => val (front, rear) = inpList.splitAt(rotBy + inpList.length)
                   rear ::: front
    case _ => inpList
  }
}

rotate(-3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))


//20 Remove kth element from list
//Takes nth element from list, takeRight gets remaining list
//nth element is added to tuple

def removeAt[T](remEle: Int, inpList: List[T]): (List[T],T) = {
  (inpList.take(remEle):::inpList.takeRight(inpList.length - remEle), inpList(remEle))
}
removeAt(1, List('a, 'b, 'c, 'd))


//21 Insert element at given position
//Splits list into front and back at insert position
//Joints them again about inserted element

def insertAt[T](insEle: T, insLoc: Int, inpList: List[T]): List[T] = {
  val (front, rear) = inpList.splitAt(insLoc)
  front ::: List(insEle) ::: rear
}

insertAt('new, 1, List('a, 'b, 'c, 'd))


//22 Create list containing all ints within range

def range(rStart: Int, rEnd: Int): List[Int] = {
  (rStart to rEnd).toList
}

range(4, 9)


//23 Extract a number of random elements
//Shuffle list with random function, take slice

def randomSelect[T](selNum: Int, inpList: List[T]): List[T] = {
  scala.util.Random.shuffle(inpList).slice(0, selNum)
}
randomSelect(4, List('a, 'b, 'c, 'd, 'f, 'g, 'h))


//24 Draw n random numbers from set
//Create list 0 - m, shuffle, take slice of size n

def lotto(sliSize: Int, rEnd: Int): List[Int] = {
  scala.util.Random.shuffle(1 to rEnd).toList.slice(0, sliSize)
}
lotto(6, 49)


//25 Generate random permutation of list elements
//Inbuilt random shuffle function

def randomPermute[T](inpList: List[T]): List[T] = {
  scala.util.Random.shuffle(inpList)
}

randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))


//26 Generate combinations of distinct objects from list
//Based from online example

def combinations[A](numEle: Int, inpList: List[A]): List[List[A]] =
  numEle match {
  case numEle if(numEle == 0) => List(Nil)
  case _ => mapSublists(inpList) { x =>
    combinations(numEle - 1, x.tail) map {x.head :: _ }
  }
}

def mapSublists[A, T](inpList: List[A])(subEle: (List[A]) => List[T]): List[T] =
  inpList match {
    case Nil => Nil
    case sublist@( _ :: tail) => subEle(sublist) ::: mapSublists(tail)(subEle)
  }

combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))


//27  Group elements of a set into disjoint subsets
//Uses previous combinations function
/*
def group3[T](inpList: List[T]): List[List[List[T]]] =
  for {
    a <- combinations(2, inpList)
    b = inpList -- a
    c <- combinations(3, b)
  } yield List(a, c, b -- c)

group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
 */  //Not working yet