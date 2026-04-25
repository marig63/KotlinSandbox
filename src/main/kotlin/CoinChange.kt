package org.example

import kotlin.Array

class CoinChange {

    private lateinit var values: Array<IntArray>

    private lateinit var minCoinPerAmountTable: IntArray

    fun coinChange(coins: IntArray, amount: Int): Int {

        if (amount == 0) return 0

        minCoinPerAmountTable = IntArray(amount + 1) { amount + 1 }

        computeMinCoinPerAmountTable(amount, coins)

        /*for (i in minCoinPerAmountTable.indices) {
            print(minCoinPerAmountTable[i].toString() + " ")
        }*/

        return if (minCoinPerAmountTable[amount] != amount + 1) minCoinPerAmountTable[amount] else -1
    }

    private fun computeMinCoinPerAmountTable(amount: Int, coins: IntArray) {

        minCoinPerAmountTable[0] = 0
        // Version 3
        for (i in 1 .. amount) {

            for (c in coins) {
                if (i - c >= 0) {
                    minCoinPerAmountTable[i] = minOf(minCoinPerAmountTable[i], 1 + minCoinPerAmountTable[i - c])
                }
            }

        }
    }

}
