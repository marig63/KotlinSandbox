package org.example.mindifficulty

class MinDifficultyTopDown {

    private var d: Int = 0
    private var totalNumberOfJobs: Int = 0
    private lateinit var jobDifficulty: IntArray

    private lateinit var memo: Array<IntArray>

    fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {

        this.d = d
        this.jobDifficulty = jobDifficulty
        this.totalNumberOfJobs = jobDifficulty.size

        this.memo = Array(totalNumberOfJobs) { IntArray(d, { -1 }) }

        if (totalNumberOfJobs < d) {
            return -1
        }

        return dp(0, 1)
    }

    // Recursive func
    // @param1 i: index of the first job to execute on the current day,
    // @param2 day: the current day
    // @return the minimum difficulty of a schedule starting on the job indexed as "i" and at day "day"
    private fun dp(i: Int, day: Int): Int {

        if (day == this.d) { // if it is the last day
            val remainingJobs = jobDifficulty.drop(i)
            val maxRemaining = remainingJobs.max() // we can return the max, as we have to finish all jobs
            return maxRemaining
        }

        // Check in memo if we already know the result
        if (memo[i][day] == -1) {
            // We need to do at least one job per day
            // But we could also do more
            // as long as there will remain enough jobs for the remaining days
            // we must leave at least "d - day" jobs at the end of the current day

            // We need to try all the possibility for a given day and return the minimum difficulty
            var minHardest = Int.MAX_VALUE
            for (possibleLastJobOfTheDay in i until totalNumberOfJobs - (d - day)) {
                // job of the day would start from "i" until "possibleLastJobOfTheDay"
                val possibleJobsOfTheDay = jobDifficulty.drop(i).dropLast(jobDifficulty.lastIndex - possibleLastJobOfTheDay)

                val hardest = possibleJobsOfTheDay.max() + dp(possibleLastJobOfTheDay + 1, day + 1) // currentHardest + minDifficultyForRemaingJobsAndDays()

                if (hardest < minHardest) {
                    minHardest = hardest
                }
            }

            memo[i][day] = minHardest
        }

        return memo[i][day]
    }

}