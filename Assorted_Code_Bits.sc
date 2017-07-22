//Atbash cipher translator
val input = "hello my name is jim".toUpperCase.toList
val cipher = ('A' to 'Z').map(e => (e, (155 - e).toChar)).toMap
val output = input.foreach(item =>
    if (item == ' ') {print(' ')}
    else {print(cipher(item))})