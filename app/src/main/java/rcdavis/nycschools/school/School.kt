package rcdavis.nycschools.school

data class School(
    val id: String,
    val name: String,
    val overview: String,
    val phoneNumber: String,
    val websiteUrl: String,
    val address: Address,
    val satScores: SATScores
) {
    companion object {
        @JvmStatic fun from(dto: SchoolDTO, satDTO: SchoolSATDTO): School {
            val numSATTestTakers = if (satDTO.numSATTestTakers != "s")
                satDTO.numSATTestTakers.toInt() else 0
            val avgSATCriticalReadingScore = if (satDTO.averageSATCriticalReadingScore != "s")
                satDTO.averageSATCriticalReadingScore.toInt() else 0
            val avgSATMathScore = if (satDTO.averageSATMathScore != "s")
                satDTO.averageSATMathScore.toInt() else 0
            val avgSATWritingScore = if (satDTO.averageSATWritingScore != "s")
                satDTO.averageSATWritingScore.toInt() else 0

            return School(
                id = dto.id,
                name = dto.name,
                overview = dto.overview,
                phoneNumber = dto.phoneNumber,
                websiteUrl = dto.websiteUrl,
                address = Address(
                    primaryAddressLine1 = dto.primaryAddressLine1,
                    city = dto.city,
                    zip = dto.zip,
                    stateCode = dto.stateCode
                ),
                satScores = SATScores(
                    id = dto.id,
                    name = dto.name,
                    numSATTestTakers = numSATTestTakers,
                    averageSATCriticalReadingScore = avgSATCriticalReadingScore,
                    averageSATMathScore = avgSATMathScore,
                    averageSATWritingScore = avgSATWritingScore
                )
            )
        }
    }
}
