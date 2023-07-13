package rcdavis.nycschools.util

import rcdavis.nycschools.school.Address
import rcdavis.nycschools.school.SATScores

object MockData {
    @JvmStatic fun getAddress() = Address(
        primaryAddressLine1 = "23423 Nkd St",
        city = "City",
        zip = 12345,
        stateCode = "OH"
    )

    @JvmStatic fun getSATScores() = SATScores(
        id = "01M292",
        schoolName = "HENRY STREET SCHOOL FOR INTERNATIONAL STUDIES",
        numSATTestTakers = 29,
        averageSATCriticalReadingScore = 355,
        averageSATMathScore = 404,
        averageSATWritingScore = 363
    )
}
