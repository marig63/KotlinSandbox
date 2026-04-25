package org.example

import kotlin.math.max

class SolutionDeleteAndEarn {

    private val memoPoints = mutableMapOf<Int, Int>()
    private val memoIntArray = mutableMapOf<Int, IntArray>()
    private val memoIntArrayValue = mutableMapOf<IntArray, Int>()
    private lateinit var nums: IntArray

    fun deleteAndEarn(nums: IntArray): Int {
        this.nums = nums

        val distinct = nums.distinct().sorted().toIntArray()

        return calculatePoints(distinct)
    }

    private fun calculatePoints(array: IntArray): Int {
        if (array.isEmpty()) return 0
        if (array.size == 1) {
            return getPoints(array[0])
        }

        if (findNeighbor(array, array[0]))  {
            val arrayWithoutFirstElement = skipFirstElements(array, 1)
            val valueArrayWithoutFirstElement = memoIntArrayValue.getOrElse(arrayWithoutFirstElement) {
                val value = calculatePoints(arrayWithoutFirstElement)
                memoIntArrayValue[arrayWithoutFirstElement] = value
                value
            }
            val arrayWithoutTwoFirstElements = skipFirstElements(array, 2)
            val valueArrayWithoutTwoFirstElements = memoIntArrayValue.getOrElse(arrayWithoutTwoFirstElements) {
                val value = calculatePoints(arrayWithoutTwoFirstElements)
                memoIntArrayValue[arrayWithoutTwoFirstElements] = value
                value
            }
            return max(getPoints(array[0]) + valueArrayWithoutTwoFirstElements, valueArrayWithoutFirstElement)
        } else {
            val arrayWithoutI = skipFirstElements(array, 1)
            return getPoints(array[0]) + calculatePoints(arrayWithoutI)
        }
    }

    private fun findNeighbor(intArray: IntArray, value: Int): Boolean {
        return intArray[1] == value + 1
    }

    private fun getPoints(num: Int): Int {
        return memoPoints.getOrElse(num) {
            val total = this.nums.count { it == num } * num
            memoPoints[num] = total
            total
        }
    }

    private fun skipFirstElements(array: IntArray, count: Int): IntArray {
        val targetArraySize = array.size - count
        return memoIntArray.getOrElse(targetArraySize) {
            val result = array.copyOfRange(count, array.size)
            memoIntArray[targetArraySize] = result
            return result
        }
    }

}

