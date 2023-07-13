package rcdavis.nycschools.school

data class SATScores(
    val id: String,
    val name: String,
    val numSATTestTakers: Int,
    val averageSATCriticalReadingScore: Int,
    val averageSATMathScore: Int,
    val averageSATWritingScore: Int
)
