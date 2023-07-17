package rcdavis.nycschools.school

data class SchoolUIState(
    val schools: List<School> = listOf(),
    val error: Throwable? = null
)
