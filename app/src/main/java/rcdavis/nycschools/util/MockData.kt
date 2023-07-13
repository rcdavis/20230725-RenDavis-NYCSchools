package rcdavis.nycschools.util

import rcdavis.nycschools.school.Address
import rcdavis.nycschools.school.SATScores
import rcdavis.nycschools.school.School

object MockData {
    @JvmStatic fun getAddress() = Address(
        primaryAddressLine1 = "220 Henry Street",
        city = "Manhattan",
        zip = 10002,
        stateCode = "NY"
    )

    @JvmStatic fun getSATScores() = SATScores(
        id = "01M292",
        name = "HENRY STREET SCHOOL FOR INTERNATIONAL STUDIES",
        numSATTestTakers = 29,
        averageSATCriticalReadingScore = 355,
        averageSATMathScore = 404,
        averageSATWritingScore = 363
    )

    @JvmStatic fun getSchools() = listOf(
        School(
            id = "01M292",
            name = "Orchard Collegiate Academy (Henry Street School)",
            overview = "Founded by the Asia Society, our school helps students acquire the knowledge and skills needed to prepare for college and/or careers while in pursuit of knowledge of the histories, economies, and languages of world regions. Teachers and other adults who make up the learning community forge supportive relationships with students and parents while providing challenging and engaging learning experiences. Our school partners with various community, arts, and business organizations to help students achieve success. Our theme of international studies extends beyond the classroom, where students participate in ongoing Â‘Advisory Day OutÂ’ excursions where the multiculturalism of NYC becomes the classroom.",
            phoneNumber = "212-406-9411",
            websiteUrl = "http://schools.nyc.gov/SchoolPortals/01/M292/default.htm",
            address = getAddress(),
            satScores = getSATScores()
        ),
        School(
            id = "01M448",
            name = "University Neighborhood High School",
            overview = "We are a small, inclusive school guided by 4 pillars: Honor, Excellence, Curiosity, and Celebration. 98% of our students go to college. Students engage in a college-bound academic program of Regents, AP, College Now courses, and study Chinese, Korean, or Japanese. We offer a robust after-school club culture supported by our student government. We encourage acts of kindness through RachelÂ’s Challenge, an anti-bullying program. Our Parent Coordinator keeps parents informed through biweekly postcards, a newsletter, and First Fridays. Grades and progress reports are available online. Seniors attend college prep classes; juniors can take onsite Kaplan SAT prep courses. Our NEST program provides significant individual support for students with autism.",
            phoneNumber = "212-962-4341",
            websiteUrl = "www.universityneighborhoodhs.org",
            address = Address(
                primaryAddressLine1 = "200 Monroe Street",
                city = "Manhattan",
                zip = 10002,
                stateCode = "NY"
            ),
            satScores = SATScores(
                id = "01M448",
                name = "UNIVERSITY NEIGHBORHOOD HIGH SCHOOL",
                numSATTestTakers = 91,
                averageSATCriticalReadingScore = 383,
                averageSATMathScore = 423,
                averageSATWritingScore = 366
            )
        )
    )
}
