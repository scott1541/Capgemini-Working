//1 Last element of a list

def last(lst: List[Int]): Int = {
  lst.last
}
last(List(1, 1, 2, 3, 5, 8))


//2 Last but one element
//If tail length is 1, so 2 items in list..
//Return head of those items

def penultimate(lst: List[Int]): Int = {
  lst match {
    case head::tail if(tail.length == 1) => head
    case head::tail => penultimate(tail)
  }
}

penultimate(List(1, 1, 2, 3, 5, 8))


//3 find nth element
//Loop through recursively n times
//Return head at that index

def nth(n: Int, lst: List[Int]): Int = {
  n match {
    case 0 => lst.head
    case _ => nth(n-1, lst.tail)
  }
}

nth(2, List(1, 1, 2, 3, 5, 8))


//4 Find number of elements in list

def length(lst: List[Int]): Int = {
  lst.length
}
length(List(1, 1, 2, 3, 5, 8))


//5 Reverse a list

def reverse(lst: List[Int]): List[Int] = {
  lst.reverse
}
reverse(List(1, 1, 2, 3, 5, 8))


//6 Is list palindrome
//Check if list is equal to reversed list
//If it is, list is a palindrome

def isPalindrome(lst: List[Int]): Boolean = {
  lst == lst.reverse
}
isPalindrome(List(1, 2, 3, 3, 2, 1))


//7 Flatted nested list
//Cannot use .flatten function
//If element is nested list, call again with head & tail of that list
//If element isn't nested, prepend head and call with tail

def flatten(lst: List[Any]): List[Any] = {
lst match {
    case Nil => Nil
    case (head:List[_]) :: tail => flatten(head) ::: flatten(tail)
    case head :: tail => head :: flatten(tail)
  }
}
flatten(List(List(1, 1), 2, List(3, List(5, 8))))


//8 Eliminate conseq duplicates
//If head is equal to head of tail, call again with tail
//Else prepend head with result of calling again

def compress[T](lst: List[T]): List[T] = {
  lst match {
    case Nil => Nil
    case head :: Nil => List(head)
    case head :: tail if(head == tail.head) => compress(tail)
    case head :: tail => head :: compress(tail)
  }
}

compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


//9 Pack conseq duplicates into sub-sequences
//If output seq is empty or head of last elem isn't equal to remaining head ->
//call again with prepended output seq and head of sub-seq
//Else call again with out - last element, prepended to seq containing last element prepended to remaining head

def pack(lst: List[Any]): List[List[Any]] = {

  def _pack(out: List[List[Any]], rem: List[Any]): List[List[Any]] = {
    rem match {
    case Nil => out
    case head :: tail if (out.isEmpty || out.last.head != head) => _pack(out ::: List(List(head)), tail)
    case head :: tail => _pack(out.init ::: List(out.last ::: List(head)), tail)
    }
  }
  _pack(List(),lst)
}
pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


//10 Encoding sub-sequences with length of the sequence (no. of occurrences)
//Uses previous pack function, then gets length of the sub-sequences
//then stored length of sub-seq with head of that seq

def encode(lst: List[Any]):List[(Int, Any)] = {
  def _encode(out: List[(Int, Any)], rem: List[List[Any]]): List[(Int, Any)] = {
    rem match {
    case Nil => out
    case head :: tail => _encode(out ::: List((head.length, head.head)), tail)
    }
  }
  _encode(List(), pack(lst))
}

encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


//11 Encode 2
//Pack into sub-sequences with pack function from earlier
//If list only contains 1 element -> use left option and store single element
//If list contains multiple -> use right option and store sub-sequence

def encode2(lst: List[Any]): List[ Either[Any,(Int, Any)] ] = {

  pack(lst) map { e =>
    e match {
      case e if e.length == 1 => Left(e.head)
      case e => Right(e.length, e.head)
    }
  }
}

encode2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


//12 Decode
//Expands tuples and maps them by using fill
// e.g (4, 'a) -> fill with a, 4 times

def decode(lst: List[(Int, Any)]): List[Any] = {
  lst flatMap { e => List.fill(e._1)(e._2) }
}

decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))


//13 Direct encode

def encodeDirect[T](lst: List[T]): List[(Int, T)] = {

    def _encodeDirect(out: List[(Int, T)], rem: List[T]): List[(Int, T)] = {
      rem match {
        case Nil => out
        case ls => { val (s, r) = rem span { _ == rem.head }
              _encodeDirect(out ::: List((s.length, s.head)), r)
        }
      }
    }
    _encodeDirect(List(), lst)
}

encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


//14 Duplicate
//Duplicates elements once by using flatmap and fill

def duplicate[T](lst: List[T]): List[T] = {
  lst flatMap {e => List.fill(2)(e)}
}

duplicate(List('a, 'b, 'c, 'c, 'd))


//15 Duplicate n times
//Same as above solution, but fill quantity is taken as an input argument

def duplicateN[T](n: Int, lst: List[T]): List[T] = {
  lst flatMap {e => List.fill(n)(e)}
}
duplicateN(3, List('a, 'b, 'c, 'c, 'd))