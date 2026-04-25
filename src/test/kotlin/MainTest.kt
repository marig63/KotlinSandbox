package kata

import org.example.mindifficulty.MinDifficultyBottomUp
import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {

    @Test
    fun `Basic Test 0`() {
        val result = MinDifficultyBottomUp()
            .minDifficulty(
                intArrayOf(6,5,10,3,2,1),
                3
            )
        assertEquals(13, result)
    }

}
