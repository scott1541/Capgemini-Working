//Intersperse - Take a list of elements (any type) and insert another
//element in between existing elements
val numList: List[Int] = List(1,2,3,4,5,6,7,8,9,10,11,12)

def intersperse[E](in: E, lst: Seq[E]): Seq[E] = {
  (in, lst) match {
    case (_, Nil) => Nil
    case (_, Seq(in)) => Seq(in)
    case (div, head :: tail) => head +: div +: intersperse(div, tail)
  }
}
//Empty list -> return empty list
//No char but sequence -> return seq
//Char + seq -> return head + char, call again
intersperse('e', numList)


//Intercalate - Similar to above but using a list, and list of lists

val numListL: List[List[Int]] = List(List(1,2,3), List(4,5,6), List(7,8,9), List(10,11,12))
val intList: List[Int] = List(0,0,0)

def intercalate[E](in: Seq[E], lst: Seq[Seq[E]]): Seq[Seq[E]] = {
  (in, lst) match {
    case (_, Nil) => Nil
    case (_, Seq(in)) => Seq(in)
    case (div, head :: tail) => head +: div +: intercalate(div, tail)

  }
}

intercalate(intList, numListL).flatten