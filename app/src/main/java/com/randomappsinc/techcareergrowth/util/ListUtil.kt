package com.randomappsinc.techcareergrowth.util

object ListUtil {

    fun<T> areListsEqual(first: List<T>, second: List<T>): Boolean {

        if (first.size != second.size) {
            return false
        }

        return first.zip(second).all { (x, y) -> x == y }
    }
}
