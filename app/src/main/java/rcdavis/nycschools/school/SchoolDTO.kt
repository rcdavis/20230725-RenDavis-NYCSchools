package rcdavis.nycschools.school

import com.google.gson.annotations.SerializedName

data class SchoolDTO(
    @SerializedName("dbn")
    val id: String,
    @SerializedName("school_name")
    val name: String,
    @SerializedName("overview_paragraph")
    val overview: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("website")
    val websiteUrl: String,
    @SerializedName("primary_address_line_1")
    val primaryAddressLine1: String,
    val city: String,
    val zip: Int,
    @SerializedName("state_code")
    val stateCode: String,
    val latitude: Double,
    val longitude: Double
)
