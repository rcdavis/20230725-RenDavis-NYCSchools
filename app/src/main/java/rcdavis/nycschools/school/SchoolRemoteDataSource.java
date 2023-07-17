package rcdavis.nycschools.school;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rcdavis.nycschools.util.CollectionUtils;
import rcdavis.nycschools.util.RetrofitUtils;

public class SchoolRemoteDataSource {
    private final SchoolAPI mSchoolApi = RetrofitUtils.createSchoolApi();

    public Observable<List<School>> getAllSchools() {
        return Observable.zip(
                mSchoolApi.getAllSchools(),
                mSchoolApi.getAllSATScores(),
                this::zipDTOLists
        );
    }

    private List<School> zipDTOLists(
            final List<SchoolDTO> schoolDTOs, final List<SchoolSATDTO> satDTOs
    ) {
        try {
            return CollectionUtils.zipLists(schoolDTOs, satDTOs,
                    (schooldto, satdto) -> StringUtils.equalsIgnoreCase(schooldto.getId(), satdto.getId()),
                    School::from);
        } catch (final Throwable e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
