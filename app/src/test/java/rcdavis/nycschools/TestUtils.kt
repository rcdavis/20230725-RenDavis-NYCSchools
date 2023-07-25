package rcdavis.nycschools

import rcdavis.nycschools.school.Address
import rcdavis.nycschools.school.SATScores
import rcdavis.nycschools.school.School
import rcdavis.nycschools.school.SchoolDTO
import rcdavis.nycschools.school.SchoolSATDTO

object TestUtils {
    @JvmStatic fun createMockSchoolDtos() = listOf(
        SchoolDTO(
            id = "02M260",
            name = "Clinton School Writers & Artists, M.S. 260",
            overview = "Students who are prepared for college must have an education that encourages them to take risks as they produce and perform. Our college preparatory curriculum develops writers and has built a tight-knit community. Our school develops students who can think analytically and write creatively. Our arts programming builds on our 25 years of experience in visual, performing arts and music on a middle school level. We partner with New Audience and the Whitney Museum as cultural partners. We are a International Baccalaureate (IB) candidate school that offers opportunities to take college courses at neighboring universities.",
            phoneNumber = "212-524-4360",
            websiteUrl = "www.theclintonschool.net",
            primaryAddressLine1 = "10 East 15th Street",
            city = "Manhattan",
            zip = 10003,
            stateCode = "NY",
            latitude = 1.0,
            longitude = 1.0
        ),
        SchoolDTO(
            id = "21K728",
            name = "Liberation Diploma Plus High School",
            overview = "The mission of Liberation Diploma Plus High School, in partnership with CAMBA, is to develop the student academically, socially, and emotionally. We will equip students with the skills needed to evaluate their options so that they can make informed and appropriate choices and create personal goals for success. Our year-round model (trimesters plus summer school) provides students the opportunity to gain credits and attain required graduation competencies at an accelerated rate. Our partners offer all students career preparation and college exposure. Students have the opportunity to earn college credit(s). In addition to fulfilling New York City graduation requirements, students are required to complete a portfolio to receive a high school diploma.",
            phoneNumber = "718-946-6812",
            websiteUrl = "schools.nyc.gov/schoolportals/21/K728",
            primaryAddressLine1 = "2865 West 19th Street",
            city = "Brooklyn",
            zip = 11224,
            stateCode = "NY",
            latitude = 2.0,
            longitude = 2.0
        ),
        SchoolDTO(
            id = "08X282",
            name = "Women's Academy of Excellence",
            overview = "The Women’s Academy of Excellence is an all-girls public high school, serving grades 9-12. Our mission is to create a community of lifelong learners, to nurture the intellectual curiosity and creativity of young women and to address their developmental needs. The school community cultivates dynamic, participatory learning, enabling students to achieve academic success at many levels, especially in the fields of math, science, and civic responsibility. Our scholars are exposed to a challenging curriculum that encourages them to achieve their goals while being empowered to become young women and leaders. Our Philosophy is GIRLS MATTER!",
            phoneNumber = "718-542-0740",
            websiteUrl = "schools.nyc.gov/SchoolPortals/08/X282",
            primaryAddressLine1 = "456 White Plains Road",
            city = "Bronx",
            zip = 10473,
            stateCode = "NY",
            latitude = 3.0,
            longitude = 3.0
        )
    )

    @JvmStatic fun createMockSatDtos() = listOf(
        SchoolSATDTO(
            id = "02M260",
            name = "Clinton School Writers & Artists, M.S. 260",
            numSATTestTakers = "443",
            averageSATCriticalReadingScore = "419",
            averageSATMathScore = "426",
            averageSATWritingScore = "410"
        ),
        SchoolSATDTO(
            id = "21K728",
            name = "Liberation Diploma Plus",
            numSATTestTakers = "10",
            averageSATCriticalReadingScore = "411",
            averageSATMathScore = "369",
            averageSATWritingScore = "373"
        ),
        SchoolSATDTO(
            id = "08X282",
            name = "Women's Academy of Excellence",
            numSATTestTakers = "44",
            averageSATCriticalReadingScore = "407",
            averageSATMathScore = "386",
            averageSATWritingScore = "378"
        )
    )

    @JvmStatic fun createMockSchoolsList() = listOf(
        School(
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
        ),
        School(
            id = "21K728",
            name = "Liberation Diploma Plus High School",
            overview = "The mission of Liberation Diploma Plus High School, in partnership with CAMBA, is to develop the student academically, socially, and emotionally. We will equip students with the skills needed to evaluate their options so that they can make informed and appropriate choices and create personal goals for success. Our year-round model (trimesters plus summer school) provides students the opportunity to gain credits and attain required graduation competencies at an accelerated rate. Our partners offer all students career preparation and college exposure. Students have the opportunity to earn college credit(s). In addition to fulfilling New York City graduation requirements, students are required to complete a portfolio to receive a high school diploma.",
            phoneNumber = "718-946-6812",
            websiteUrl = "schools.nyc.gov/schoolportals/21/K728",
            address = Address(
                primaryAddressLine1 = "2865 West 19th Street",
                city = "Brooklyn",
                zip = 11224,
                stateCode = "NY"
            ),
            satScores = SATScores(
                id = "21K728",
                name = "Liberation Diploma Plus",
                numSATTestTakers = 10,
                averageSATCriticalReadingScore = 411,
                averageSATMathScore = 369,
                averageSATWritingScore = 373
            )
        ),
        School(
            id = "08X282",
            name = "Women's Academy of Excellence",
            overview = "The Women’s Academy of Excellence is an all-girls public high school, serving grades 9-12. Our mission is to create a community of lifelong learners, to nurture the intellectual curiosity and creativity of young women and to address their developmental needs. The school community cultivates dynamic, participatory learning, enabling students to achieve academic success at many levels, especially in the fields of math, science, and civic responsibility. Our scholars are exposed to a challenging curriculum that encourages them to achieve their goals while being empowered to become young women and leaders. Our Philosophy is GIRLS MATTER!",
            phoneNumber = "718-542-0740",
            websiteUrl = "schools.nyc.gov/SchoolPortals/08/X282",
            address = Address(
                primaryAddressLine1 = "456 White Plains Road",
                city = "Bronx",
                zip = 10473,
                stateCode = "NY"
            ),
            satScores = SATScores(
                id = "08X282",
                name = "Women's Academy of Excellence",
                numSATTestTakers = 44,
                averageSATCriticalReadingScore = 407,
                averageSATMathScore = 386,
                averageSATWritingScore = 378
            )
        )
    )
}
