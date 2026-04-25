package kata

import org.example.LongestCommonSubsequence
import kotlin.test.Test
import kotlin.test.assertEquals

class LongestCommonSubsequenceTest {

    @Test fun `Basic Test 1`() {
        val result = LongestCommonSubsequence().longestCommonSubsequence(text1 = "abcde", text2 = "ace")
        assertEquals(3, result)
    }

    @Test fun `Basic Test 2`() {
        val result = LongestCommonSubsequence().longestCommonSubsequence(text1 = "abc", text2 = "abc")
        assertEquals(3, result)
    }

    @Test fun `Basic Test 3`() {
        val result = LongestCommonSubsequence().longestCommonSubsequence(text1 = "abc", text2 = "def")
        assertEquals(0, result)
    }

    @Test fun `Basic Test 4`() {
        val result = LongestCommonSubsequence().longestCommonSubsequence(
            text1 = "bsbininm",
            text2 = "jmjkbkjkv"
        )
        assertEquals(1, result)
    }

}
