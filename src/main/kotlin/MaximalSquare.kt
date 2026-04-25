package org.example

import kotlin.math.max
import kotlin.math.pow

// Second try bottom-up
class MaximalSquare {
    fun maximalSquare(matrix: Array<CharArray>): Int {

        val dp = Array(matrix.size) {
            Array(
                matrix[0].size,
                init = {
                    Pair(0, 0)
                }
            )
        }

        val m = matrix.size
        val n = matrix[0].size

        for (i in (m - 1) downTo 0) {
            for (j in (n - 1) downTo 0) {

                val value = matrix[i][j].digitToInt()

                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Pair(value, value)
                } else if (i == m - 1) {
                    val max = max(matrix[i][j].digitToInt(), matrix[i][j + 1].digitToInt())
                    dp[i][j] = Pair(value, max)
                } else if (j == n - 1) {
                    val max = max(matrix[i][j].digitToInt(), matrix[i + 1][j].digitToInt())
                    dp[i][j] = Pair(value, max)
                } else if (
                    value == 1 &&
                    dp[i + 1][j + 1].first > 0
                ) {
                    val diagValue = dp[i + 1][j + 1].first
                    val rightValue = dp[i + 1][j].first
                    val bottomValue = dp[i][j + 1].first

                    val diagMax = dp[i + 1][j + 1].second
                    val rightMax = dp[i + 1][j].second
                    val bottomMax = dp[i][j + 1].second

                    if (
                        rightValue >= diagValue &&
                        bottomValue >= diagValue
                    ) {
                        val newCurrent = diagValue + 1
                        val maxOfMaxs = maxOf(
                            diagValue,
                            rightValue,
                            bottomValue,
                            newCurrent,
                            diagMax,
                            rightMax,
                            bottomMax
                        )
                        dp[i][j] = Pair(newCurrent, maxOfMaxs)
                    } else {
                        val maxOfMaxs = maxOf(
                            diagValue,
                            rightValue,
                            bottomValue,
                            diagMax,
                            rightMax,
                            bottomMax
                        )
                        val minOfValues = minOf(diagValue, bottomValue, rightValue)
                        val newCurrent = minOfValues + 1
                        dp[i][j] = Pair(newCurrent, maxOfMaxs)
                    }
                } else {
                    val diagMax = dp[i + 1][j + 1].second
                    val rightMax = dp[i + 1][j].second
                    val bottomMax = dp[i][j + 1].second

                    val maxOfMaxs = maxOf(diagMax, rightMax, bottomMax, value)

                    dp[i][j] = Pair(value, maxOfMaxs)
                }

            }
        }

        return dp[0][0].second.toDouble().pow(2).toInt()
    }
}


// First try bottom-up
/*class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {

        val dp = Array(matrix.size) { Array<Pair<Int, Boolean>>(
            matrix[0].size,
            init = {
                Pair(0, false)
            }
        ) }

        val m = matrix.size
        val n = matrix[0].size

        for (i in (m - 1) downTo 0) {
            for (j in (n - 1) downTo 0) {
                if (i == m - 1 && j == n - 1) {
                    val value = matrix[i][j].digitToInt()
                    dp[i][j] = Pair(value, value == 1)
                } else if (i == m - 1) {
                    val value = max(matrix[i][j].digitToInt(), matrix[i][j + 1].digitToInt())
                    dp[i][j] = Pair(value, matrix[i][j].digitToInt() == 1)
                } else if (j == n - 1) {
                    val value = max(matrix[i][j].digitToInt(), matrix[i + 1][j].digitToInt())
                    dp[i][j] = Pair(value, matrix[i][j].digitToInt() == 1)
                } else if (
                    matrix[i][j].digitToInt() == 1 &&
                    /*matrix[i][j] == matrix[i + 1][j] &&
                    matrix[i][j] == matrix[i + 1][j + 1] &&
                    matrix[i][j] == matrix[i][j + 1]*/
                    dp[i + 1][j].first == dp[i + 1][j + 1].first &&
                    dp[i][j + 1].first == dp[i + 1][j + 1].first
                ) {
//                    dp[i][j] = 1 + minOf(dp[i + 1][j], dp[i + 1][j + 1], dp[i][j + 1])
                    val continuous = (dp[i + 1][j].second && dp[i + 1][j + 1].second && dp[i][j + 1].second)
                    dp[i][j] = Pair(
                        (if (continuous) 1 else 0) + minOf(dp[i + 1][j].first, dp[i + 1][j + 1].first, dp[i][j + 1].first),
                        continuous
                    )
                } else {
//                    dp[i][j] = maxOf(/*matrix[i][j].digitToInt(), */dp[i + 1][j], dp[i + 1][j + 1], dp[i][j + 1])
                    dp[i][j] = Pair(maxOf(dp[i + 1][j].first, dp[i + 1][j + 1].first, dp[i][j + 1].first), false)
                }

            }
        }

        for (i in dp.indices) {
            println(dp[i].toList())
        }

        return dp[0][0].first.toDouble().pow(2).toInt()
    }
}*/