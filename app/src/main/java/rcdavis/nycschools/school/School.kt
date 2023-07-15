package rcdavis.nycschools.school

data class School(
    val id: String,
    val name: String,
    val overview: String,
    val phoneNumber: String,
    val websiteUrl: String,
    val address: Address,
    val satScores: SATScores
)
