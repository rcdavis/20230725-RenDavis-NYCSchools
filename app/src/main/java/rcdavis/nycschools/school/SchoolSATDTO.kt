package rcdavis.nycschools.school

import com.google.gson.annotations.SerializedName

data class SchoolSATDTO(
    @SerializedName("dbn")
    val id: String,
    @SerializedName("school_name")
    val name: String,
    @SerializedName("num_of_sat_test_takers")
    val numSATTestTakers: String,
    @SerializedName("sat_critical_reading_avg_score")
    val averageSATCriticalReadingScore: String,
    @SerializedName("sat_math_avg_score")
    val averageSATMathScore: String,
    @SerializedName("sat_writing_avg_score")
    val averageSATWritingScore: String
)
