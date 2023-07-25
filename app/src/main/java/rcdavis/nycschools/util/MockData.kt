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

    @JvmStatic fun getMockSchool() = School(
        id = "02M260",
        name = "Clinton School Writers & Artists, M.S. 260",
        overview = "Students who are prepared for college must have an education that encourages them to take risks as they produce and perform. Our college preparatory curriculum develops writers and has built a tight-knit community. Our school develops students who can think analytically and write creatively. Our arts programming builds on our 25 years of experience in visual, performing arts and music on a middle school level. We partner with New Audience and the Whitney Museum as cultural partners. We are a International Baccalaureate (IB) candidate school that offers opportunities to take college courses at neighboring universities.",
        phoneNumber = "212-524-4360",
        websiteUrl = "www.theclintonschool.net",
        address = Address(
            primaryAddressLine1 = "10 East 15th Street",
            city = "Manhattan",
            zip = 10003,
            stateCode = "NY"
        ),
        satScores = SATScores(
            id = "02M260",
            name = "Clinton School Writers & Artists, M.S. 260",
            numSATTestTakers = 443,
            averageSATCriticalReadingScore = 419,
            averageSATMathScore = 426,
            averageSATWritingScore = 410
        )
    )
}
