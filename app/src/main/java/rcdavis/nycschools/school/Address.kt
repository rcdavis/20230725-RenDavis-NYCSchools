package rcdavis.nycschools.school

import android.net.Uri

class Address(
    val primaryAddressLine1: String,
    val city: String,
    val zip: Int,
    val stateCode: String,
    val latitude: Double,
    val longitude: Double
) {
    override fun toString(): String {
        return "$primaryAddressLine1,\n$city, $stateCode $zip"
    }

    var mapUri: Uri = Uri.parse(
        "geo:$latitude,$longitude?q=${
            Uri.decode("$primaryAddressLine1, $city, $stateCode $zip")
        }"
    )
}
