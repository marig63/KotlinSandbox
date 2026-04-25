package kata

import org.example.MaximalSquare
import kotlin.test.Test
import kotlin.test.assertEquals

class MaximalSquareTest {
    @Test fun `Basic Test 1`() {
        val matrix = arrayOf(
            charArrayOf('1','0','1','0','0'),
            charArrayOf('1','0','1','1','1'),
            charArrayOf('1','1','1','1','1'),
            charArrayOf('1','0','0','1','0')
        )

        val result = MaximalSquare().maximalSquare(matrix = matrix)
        assertEquals(4, result)
    }

    @Test fun `Basic Test 2`() {
        val matrix = arrayOf(
            charArrayOf('0','1'),
            charArrayOf('1','0')
        )

        val result = MaximalSquare().maximalSquare(matrix = matrix)
        assertEquals(1, result)
    }

    @Test fun `Basic Test 3`() {
        val matrix = arrayOf(
            charArrayOf('0')
        )

        val result = MaximalSquare().maximalSquare(matrix = matrix)
        assertEquals(0, result)
    }

    @Test fun `Basic Test 4`() {
        val matrix = arrayOf(
            charArrayOf('0', '1')
        )

        val result = MaximalSquare().maximalSquare(matrix = matrix)
        assertEquals(1, result)
    }

    @Test fun `Basic Test 5`() {
        val matrix = arrayOf(
            charArrayOf('0','0'),
            charArrayOf('0','0')
        )

        val result = MaximalSquare().maximalSquare(matrix = matrix)
        assertEquals(0, result)
    }

    @Test fun `Basic Test 6`() {
        val matrix = arrayOf(
            charArrayOf('1','0'),
            charArrayOf('0','0')
        )

        val result = MaximalSquare().maximalSquare(matrix = matrix)
        assertEquals(1, result)
    }

    @Test fun `Basic Test 7`() {
        val matrix = arrayOf(
            charArrayOf('1','1','1','1','1'),
            charArrayOf('1','1','1','1','1'),
            charArrayOf('0','0','0','0','0'),
            charArrayOf('1','1','1','1','1'),
            charArrayOf('1','1','1','1','1'),
        )

        val result = MaximalSquare().maximalSquare(matrix = matrix)
        assertEquals(4, result)
    }

    @Test fun `Basic Test 8`() {
        val matrix = arrayOf(
            charArrayOf('1','1','1','1','0'),
            charArrayOf('1','1','1','1','0'),
            charArrayOf('1','1','1','1','1'),
            charArrayOf('1','1','1','1','1'),
            charArrayOf('0','0','1','1','1'),
        )

        val result = MaximalSquare().maximalSquare(matrix = matrix)
        assertEquals(16, result)
    }

    @Test fun `Basic Test 9`() {
        val matrix = arrayOf(
            charArrayOf('1','0','1','1','1'),
            charArrayOf('0','1','0','1','0'),
            charArrayOf('1','1','0','1','1'),
            charArrayOf('1','1','0','1','1'),
            charArrayOf('0','1','1','1','1'),
        )

        val result = MaximalSquare().maximalSquare(matrix = matrix)
        assertEquals(4, result)
    }

    @Test fun `Basic Test 10`() {
        val matrix = arrayOf(
            charArrayOf('0','1','1','0','0','1','0','1','0','1'),
            charArrayOf('0','0','1','0','1','0','1','0','1','0'),
            charArrayOf('1','0','0','0','0','1','0','1','1','0'),
            charArrayOf('0','1','1','1','1','1','1','0','1','0'),
            charArrayOf('0','0','1','1','1','1','1','1','1','0'),
            charArrayOf('1','1','0','1','0','1','1','1','1','0'),
            charArrayOf('0','0','0','1','1','0','0','0','1','0'),
            charArrayOf('1','1','0','1','1','0','0','1','1','1'),
            charArrayOf('0','1','0','1','1','0','1','0','1','1'),
        )

        val result = MaximalSquare().maximalSquare(matrix = matrix)
        assertEquals(4, result)
    }
}