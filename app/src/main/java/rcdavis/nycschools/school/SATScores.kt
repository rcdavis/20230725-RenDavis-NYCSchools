package rcdavis.nycschools.school

data class SATScores(
    val id: String,
    val schoolName: String,
    val numSATTestTakers: Int,
    val averageSATCriticalReadingScore: Int,
    val averageSATMathScore: Int,
    val averageSATWritingScore: Int
)
