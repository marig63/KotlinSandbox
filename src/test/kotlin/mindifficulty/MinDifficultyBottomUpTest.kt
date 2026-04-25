package kata.mindifficulty

import org.example.mindifficulty.MinDifficultyBottomUp
import kotlin.test.Test
import kotlin.test.assertEquals

class MinDifficultyBottomUpTest {
    @Test fun `Basic Test 0`() {
        val result = MinDifficultyBottomUp()
            .minDifficulty(
                intArrayOf(6,5,10,3,2,1),
                3
            )
        assertEquals(13, result)
    }

    @Test
    fun `Basic Test 1`() {
        val result = MinDifficultyBottomUp().minDifficulty(
            jobDifficulty = intArrayOf(6,5,4,3,2,1),
            d = 2
        )
        assertEquals(7, result)
    }

    @Test
    fun `Basic Test 2`() {
        val result = MinDifficultyBottomUp().minDifficulty(
            jobDifficulty = intArrayOf(9,9,9),
            d = 4
        )
        assertEquals(-1, result)
    }

    @Test
    fun `Basic Test 3`() {
        val result = MinDifficultyBottomUp().minDifficulty(
            jobDifficulty = intArrayOf(1,1,1),
            d = 3
        )
        assertEquals(3, result)
    }

    @Test
    fun `Basic Test 4`() {
        val result = MinDifficultyBottomUp().minDifficulty(
            jobDifficulty = intArrayOf(11,111,22,222,33,333,44,444),
            d = 6
        )
        assertEquals(843, result)
    }

    @Test
    fun `Basic Test 5`() {
        val result = MinDifficultyBottomUp().minDifficulty(
            jobDifficulty = intArrayOf(380,302,102,681,863,676,243,671,651,612,162,561,394,856,601,30,6,257,921,405,716,126,158,476,889,699,668,930,139,164,641,801,480,756,797,915,275,709,161,358,461,938,914,557,121,964,315),
            d = 10
        )
        assertEquals(3807, result)
    }
}