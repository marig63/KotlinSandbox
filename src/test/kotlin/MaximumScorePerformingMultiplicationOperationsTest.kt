package kata

import org.example.MaximumScorePerformingMultiplicationOperations
import kotlin.test.Test
import kotlin.test.assertEquals

class MaximumScorePerformingMultiplicationOperationsTest {

    @Test fun `Basic Test 1`() {
        val result = MaximumScorePerformingMultiplicationOperations().maximumScore(intArrayOf(1,2,3), intArrayOf(3,2,1))
        assertEquals(14, result)
    }

    @Test fun `Basic Test 2`() {
        val result = MaximumScorePerformingMultiplicationOperations().maximumScore(intArrayOf(-5,-3,-3,-2,7,1), intArrayOf(-10,-5,3,4,6))
        assertEquals(102, result)
    }

}