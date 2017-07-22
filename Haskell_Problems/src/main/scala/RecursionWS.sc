//fibonacci sequence
def fib(x: Int): Int =  {
x match {
  case 0 => 0
  case 1 => 1
  case _ => fib(x-1) + fib(x-2)
}}
//Check if input is 0 or 1, and output 0 or 1 respectively
//if not then output the sum of the previous two numbers

fib(16) // -> res0: Int = 987

//Maximum
val nums: Seq[Int] = List(2,1,3,19,7,5,10,15,11)

def max(nums: Seq[Int]): Int = {
  nums match {
    case Nil => 0
    case head :: Nil => head
    case head :: tail if head >= tail.max => head
    case head :: tail if head < tail.max => max(tail)
      // check if the list is empty -> return 0
      // check if tail is empty -> return head
      // check if the head >= maximum number -> return 0
      // check if the head < maximum number -> call again with tail
  }
}
max(nums) // -> res1: Int = 19

//Replicate
var repeat: Seq[Int] = List()
def replicate(a: Int, b:Int): Seq[Int] = {
  b match {
    case 0 => repeat
    case _ => repeat = repeat:+a; replicate(a, b-1)
  }
}
//Replicate the first value(a),  b times
replicate(54,5) // -> res2: Seq[Int] = List(54, 54, 54, 54, 54)

//Take
val nums2: Seq[Int] = List(1,2,3,19,7,8,10,15,11)
var outp: Seq[Int] = List()

def take(tk: Int, nums2: Seq[Int]): Seq[Int] = {
  tk match {
    case 0 => outp
    case _ => outp = outp:+ nums2.head; take(tk-1, nums2.tail)
  }
}
//Takes first 3 elements from the sequence
take(3, nums2) // -> res3: Seq[Int] = List(1, 2, 3)


//Reverse
//Reverses order of a list, makes use of currying
//Using type List[] for this as (output.::(head)) gives error as it needs list
val list1: List[Int] = List(1,2,3,4,5,6,7,8,9)
val list2: List[Int] = List()

def reverse(input: List[Int])(output: List[Int]): List[Int] = {
  input match {
    case Nil => output
    case head :: tail => reverse(tail)(output.::(head))
    case _ => output
  }
}
reverse(list1)(list2)  // => res4: List[Int] = List(9, 8, 7, 6, 5, 4, 3, 2, 1)


//Zip
//Join two lists recursively, makes use of currying
//Using type List[] for this as (output.::(head)) gives error as it needs list
val zList1 = List(1,2,3,4,5)
val zList2 = List(6,7,8,9,10,11,12)

def zip(input: List[Int]) (output: List[Int]): List[Int] =
input match {
  case Nil => output
  case head :: tail => zip(tail)(output.::(head))
  case _ => output
}

zip(zList1)(zList2) // ->res5:  List[Int] = List(5, 4, 3, 2, 1, 6, 7, 8, 9, 10, 11, 12)

//Element exists
//Finds if an element (char) exists within a sequence
var lst: Seq[Char] = List('a','b', 'c', 'd', 'e', 'f', 'x', 'y', 'z')

def exists(elem: Char, lst: Seq[Char]): Any = {
	lst match {
		case Nil => 0
		case head :: tail if (head == elem) => 1
		case head :: Nil => 0
		case head :: tail => exists(elem, tail)
	}
}

exists('x', lst) // -> res6: Any = 1
//Output 1 = True, 0 = False, bool not working properly on this machine


//Quicksort
//Sort list into ascending order
//Pivot is middle point in sequence, searches either side of pivot

def quickSort(nums: Seq[Int]): Seq[Int] = {
  if (nums.length <= 1) nums
  else {
    val pivot = nums(nums.length / 2)
    Seq.concat(quickSort(nums filter (pivot >)),
      nums filter (pivot ==),
      quickSort(nums filter (pivot <)))
  }}

quickSort(nums) // -> res7: Seq[Int] = List(1, 2, 3, 5, 7, 10, 11, 15, 19)

