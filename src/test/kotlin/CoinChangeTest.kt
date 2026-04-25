package kata

import org.example.CoinChange
import kotlin.test.Test
import kotlin.test.assertEquals

class CoinChangeTest {

    @Test fun `Basic Test 1`() {
        val result = CoinChange().coinChange(
            coins = intArrayOf(1, 2, 5),
            amount = 11
        )
        assertEquals(3, result)
    }

    @Test fun `Basic Test 2`() {
        val result = CoinChange().coinChange(
            coins = intArrayOf(2),
            amount = 3
        )
        assertEquals(-1, result)
    }

    @Test fun `Basic Test 3`() {
        val result = CoinChange().coinChange(
            coins = intArrayOf(1),
            amount = 0
        )
        assertEquals(0, result)
    }

    @Test fun `Basic Test 4`() {
        val result = CoinChange().coinChange(
            coins = intArrayOf(2),
            amount = 4
        )
        assertEquals(2, result)
    }

    @Test fun `Basic Test 5`() {
        val result = CoinChange().coinChange(
            coins = intArrayOf(1, 3, 5),
            amount = 7
        )
        assertEquals(3, result)
    }

    @Test fun `Basic Test 6`() {
        val result = CoinChange().coinChange(
            coins = intArrayOf(1, 2, 5, 10),
            amount = 18
        )
        assertEquals(4, result)
    }

    @Test fun `Basic Test 7`() {
        val result = CoinChange().coinChange(
            coins = intArrayOf(186, 419, 83, 408),
            amount = 6249
        )
        assertEquals(20, result)
    }


}