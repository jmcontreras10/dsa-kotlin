package org.example.algorithms.graphs

fun <T: Comparable<T>> binarySearch(array: Array<T>, target: T): Int {
    var min = 0
    var max = array.size

    while (min < max) {
        val mid = ((max - min)/ 2) + min
        val comparison = array[mid].compareTo(target)
        if (comparison == 0) return mid
        else if (comparison < 0) min = mid + 1
        else max = mid -1
    }
    return -1
}