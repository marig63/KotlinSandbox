package kata

import org.example.SolutionDeleteAndEarn
import kotlin.test.Test
import kotlin.test.assertEquals

class DeleteAndEarnTest {

    @Test fun `Basic Test 1`() {
        val result = SolutionDeleteAndEarn().deleteAndEarn(intArrayOf(3,4,2))
        assertEquals(6, result)
    }

    @Test fun `Basic Test 2`() {
        val result = SolutionDeleteAndEarn().deleteAndEarn(intArrayOf(2,2,3,3,3,4))
        assertEquals(9, result)
    }

    @Test fun `Basic Test 3`() {
        val result = SolutionDeleteAndEarn().deleteAndEarn(intArrayOf(1,1,3,3,3,4,7,7,8,9,9,9))
        assertEquals(52, result)
    }

    @Test fun `Basic Test 4`() {
        val result = SolutionDeleteAndEarn().deleteAndEarn(intArrayOf(8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4))
        assertEquals(61, result)
    }

    @Test fun `Basic Test 5`() {
        val result = SolutionDeleteAndEarn().deleteAndEarn(intArrayOf(12,32,93,17,100,72,40,71,37,92,58,34,29,78,11,84,77,90,92,35,12,5,27,92,91,23,65,91,85,14,42,28,80,85,38,71,62,82,66,3,33,33,55,60,48,78,63,11,20,51,78,42,37,21,100,13,60,57,91,53,49,15,45,19,51,2,96,22,32,2,46,62,58,11,29,6,74,38,70,97,4,22,76,19,1,90,63,55,64,44,90,51,36,16,65,95,64,59,53,93))
        assertEquals(3451, result)
    }

}
