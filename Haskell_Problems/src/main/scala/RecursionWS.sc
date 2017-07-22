//fibonacci sequence
def fib(x: Int): Int =  {
x match {
  case 0 => 0
  case 1 => 1
  case _ => fib(x-1) + fib(x-2)
}}
//Check if input is 0 or 1, and output 0 or 1 respectively
//if not then output the sum of the previous two numbers

//fib(16)

//Maximum
val nums: Seq[Int] = List(2,1,3,19,7,5,10,15,11)

def max(nums: Seq[Int]): Int = {
  nums match {
    case Nil => 0
    case head :: Nil => head
    case head :: tail if head >= tail.max => head
    case head :: tail if head < tail.max => max(tail)
      // check if the list is empty and if so return 0
      // check if tail is empty and if so return head
      // check if the head is more or equal to the maximum number left in the tail and if so head is the max
      // check if the head is less than the maximum number left in the tail call the function again with the tail
  }
}
//max(nums)

//Replicate
var repeat: Seq[Int] = List()
def replicate(a: Int, b:Int): Seq[Int] = {
  b match {
    case 0 => repeat
    case _ => repeat = repeat:+a; replicate(a, b-1)
  }
}
//Replicate the first value(a),  b times
//replicate(54,5)

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
//take(3, nums2)


//Reverse
var list1: Seq[Int] = List(1,2,3,4,5)
var list2: Seq[Int] = List()

def reverse(la: Seq[Int], lb: Seq[Int]): Seq[Int] = {
  la match {
    case Nil => lb
    case _ => list2 = list2:+ la.head; reverse(la.tail, lb);
  }
}

reverse(list1,list2)


//Repeat
//Zip

//Element exists

var lst: Seq[Char] = List('a','b', 'c', 'd', 'e', 'f', 'x', 'y', 'z')

def exists(elem: Char, lst: Seq[Char]): Any = {
	lst match {
		case Nil => 0
		case head :: tail if (head == elem) => 1
		case head :: Nil => 0
		case head :: tail => exists(elem, tail)
	}
}

exists('x', lst)
//Output 1 = True, 0 = False, bool not working properly on this machine


//Quicksort
def quickSort(nums: Seq[Int]): Seq[Int] = {
  if (nums.length <= 1) nums
  else {
    val pivot = nums(nums.length / 2)
    Seq.concat(quickSort(nums filter (pivot >)),
      nums filter (pivot ==),
      quickSort(nums filter (pivot <)))
  }}
//Pivot is middle point in sequence, searches either side of pivot
//quickSort(nums)
