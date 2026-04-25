package org.example

import kotlin.math.max

// fifth try bottom-up approach without help
class MaximumScorePerformingMultiplicationOperations {

    private lateinit var nums: IntArray
    private lateinit var multipliers: IntArray

    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        this.nums = nums
        this.multipliers = multipliers

        val dp: Array<IntArray> = Array(multipliers.size + 1) { IntArray(multipliers.size + 1) }

        for (i in (multipliers.size - 1) downTo 0) {
            val multiplier = multipliers[i]

            for (j in i downTo 0) {
                val rightIndex = (nums.size - 1) - (i - j)
                dp[i][j] =  max(
                    (multiplier * nums[j]) + dp[(i + 1)][j + 1],
                    (multiplier * nums[rightIndex]) + dp[i + 1][j]
                )
            }

        }

        return dp[0][0]
    }
}

/*
// fourth try top-down approach without help
/*class MaximumScorePerformingMultiplicationOperations {

    private lateinit var nums: IntArray
    private lateinit var multipliers: IntArray

    private lateinit var memo: Array<IntArray>

    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        this.nums = nums
        this.multipliers = multipliers

        this.memo = Array(multipliers.size) { IntArray(nums.size) }

        return dp(0, 0)
    }

    private fun dp(multiplierConsumed: Int, leftIndex: Int): Int {

        if (multiplierConsumed == multipliers.size) {
            return 0
        }

        val rightIndex = (nums.size - 1) - (multiplierConsumed - leftIndex)
        val currentMultiplier = multipliers[multiplierConsumed]

        if (memo[multiplierConsumed][leftIndex] == 0) {
            memo[multiplierConsumed][leftIndex] = max(
                (currentMultiplier * nums[leftIndex]) + dp(multiplierConsumed + 1, leftIndex + 1),
                (currentMultiplier * nums[rightIndex]) + dp(multiplierConsumed + 1, leftIndex)
            )
        }

        return memo[multiplierConsumed][leftIndex]
    }

}*/

 */

// Third try => bottom-up
/*class MaximumScorePerformingMultiplicationOperations {

    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        val dp: Array<IntArray> = Array(multipliers.size + 1) { IntArray(multipliers.size + 1) }

        for (m in multipliers.size - 1 downTo 0) {
            for (left in m downTo 0) {
                val multiplier = multipliers[m]
                val right = nums.size - 1 - (m - left)

                dp[m][left] = max(
                    (multiplier * nums[left]) + dp[m + 1][left + 1],
                    (multiplier * nums[right]) + dp[m + 1][left],
                )
            }
        }

        return dp[0][0]
    }

}*/

// Second try => working top-down
/*class MaximumScorePerformingMultiplicationOperations {

    private lateinit var nums: IntArray
    private lateinit var multipliers: IntArray
    private lateinit var memo: Array<IntArray>

    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        this.memo = Array(nums.size) { IntArray(multipliers.size) }

        this.nums = nums
        this.multipliers = multipliers

        return dp(0, 0)
    }

    private fun dp(i: Int, left: Int): Int {
        if (i == multipliers.size) {
            return 0
        }

        val right = nums.size - 1 - (i - left)
        val multiplier = multipliers[i]

        if (memo[i][left] == 0) {
            memo[i][left] = max(
                (multiplier * nums[left]) + dp(i + 1, left + 1),
                (multiplier * nums[right]) + dp(i + 1, left),
            )
        }

        return memo[i][left]
    }

}*/


// first try
/*
class MaximumScorePerformingMultiplicationOperations {
    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {

        val dp: Array<IntArray> = Array(nums.size) { IntArray(multipliers.size) }
        var score = 0

        var intermediateNums: IntArray = nums

        multipliers.forEachIndexed { i, multiplier ->
            println("mult: $multiplier")




            if ( multiplier * intermediateNums[0] >= multiplier * intermediateNums[intermediateNums.size - 1]) {
                println("Choose from the start: ${multiplier * intermediateNums[0]}")
                score += multiplier * intermediateNums[0]
                intermediateNums = intermediateNums.drop(1).toIntArray()
            } else {
                println("Choose from the end: ${multiplier * intermediateNums[intermediateNums.size - 1]}")
                score +=  multiplier * intermediateNums[intermediateNums.size - 1]
                intermediateNums = intermediateNums.dropLast(1).toIntArray()
            }
        }

        return score
    }
}*/