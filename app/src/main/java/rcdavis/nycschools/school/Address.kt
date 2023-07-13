package rcdavis.nycschools.school

data class Address(
    val primaryAddressLine1: String,
    val city: String,
    val zip: Int,
    val stateCode: String
)
