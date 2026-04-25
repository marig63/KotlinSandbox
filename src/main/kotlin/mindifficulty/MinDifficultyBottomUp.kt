package org.example.mindifficulty

class MinDifficultyBottomUp {

    private lateinit var jobDifficulty: IntArray
    private lateinit var dp: Array<IntArray>

    fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {

        if (jobDifficulty.size < d) {
            return -1
        }

        this.jobDifficulty = jobDifficulty
        dp = Array(jobDifficulty.size) { IntArray(d + 1) { Int.MAX_VALUE } }

        // populate best cases => last day
        for (i in jobDifficulty.indices.reversed()) {
            dp[i][d] = maxRemainingDifficulty(i)
        }

        // Loop on each day -> day between d-1 to 1
        for (day in (d-1) downTo  1) {

            // Loop -> i between (day - 1) excluding remainingReservedTasks
            for (i in (day-1) until (jobDifficulty.size - (d - day))) {
                // calculate the minDifficulty by taking one, two, tree, more tasks for adding to his diag value
                // val minHardest =
                //  min(minHardest, possibleJobsOfTheDay.max() + dp(possibleLastJobOfTheDay + 1, day + 1))

                var minHardest = Int.MAX_VALUE
                // Loop -> on all possibilities and keep the minDifficulties for the current dp[i][d]
                for (possibleLastJobOfTheDay in i until (jobDifficulty.size - (d - day))) {

                    val possibleJobsOfTheDay = jobDifficulty.drop(i).dropLast(jobDifficulty.lastIndex - possibleLastJobOfTheDay)

                    val hardest = possibleJobsOfTheDay.max() + dp[possibleLastJobOfTheDay + 1][day + 1] // currentHardest + minDifficultyForRemaingJobsAndDays()

                    if (hardest < minHardest) {
                        minHardest = hardest
                    }

                }

                dp[i][day] = minHardest
                // set the min hardest
            }

        }

        return dp[0][1]
    }

    private fun maxRemainingDifficulty(index: Int): Int {
        return jobDifficulty.drop(index).max()
    }
}