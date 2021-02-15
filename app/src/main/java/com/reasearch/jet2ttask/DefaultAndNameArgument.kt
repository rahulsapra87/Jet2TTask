package com.reasearch.jet2ttask


fun displayBorderUsingDefaultArguments(character: Char = '=', length: Int = 15) {
    for (i in 1..length) {
        print(character)
    }
}

fun displayBorderUsingNamedArguments(character: Char = '=', length: Int = 15) {
    for (i in 1..length) {
        print(character)
    }
}

fun Int.pixelsToDP() = this/2 // apply calculation here


fun Int.dpToPixel() = this * 1.5 // apply calculation here

fun main() {
    println("Example of both default arguments")
    println("Output when no argument is passed:  = will be print 15 times")
    displayBorderUsingDefaultArguments()

    println("\n\n'*' is used as a first argument and 15 is default argument")
    println("Output when only first argument is passed: * will be print 15 times")
    displayBorderUsingDefaultArguments('*')

    println("\n\n'*' is used as a first argument.")
    println("5 is used as a second argument.")
    println("Output when both arguments are passed: * will be print 5 times")
    displayBorderUsingDefaultArguments('*', 5)

    //below invocation with second argument will give error as default arguments starts from beginning. to solve this error we have name arguments.
    //displayBorderUsingDefaultArguments(5)

    println("\n\n'=' is used as a first default argument.")
    println("5 is used as a second argument as named argument.")
    println("Output when NAMED arguments are passed: = will be print 5 times")
    displayBorderUsingNamedArguments(length = 5)

    println("\n\n Examples of extention functions")
    println("\n\n convert to dp value to pixel")
    print(10.dpToPixel())

    println("\n\n convert to pixels value to dp")
    print(10.pixelsToDP())
}