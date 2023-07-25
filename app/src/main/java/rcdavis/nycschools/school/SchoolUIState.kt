package rcdavis.nycschools.school

sealed interface SchoolUIState {
    companion object {
        @JvmStatic fun loading(): SchoolUIState = SchoolLoadingUIState
        @JvmStatic fun fromList(schools: List<School>): SchoolUIState = SchoolListUIState(schools)
        @JvmStatic fun fromError(error: Throwable): SchoolUIState = SchoolErrorUIState(error)
        @JvmStatic fun emptyList(): SchoolUIState = SchoolEmptyListUIState
    }
}

object SchoolLoadingUIState : SchoolUIState
data class SchoolListUIState(val schools: List<School>): SchoolUIState
object SchoolEmptyListUIState : SchoolUIState
data class SchoolErrorUIState(val error: Throwable): SchoolUIState
