package rcdavis.nycschools.school;

import androidx.annotation.NonNull;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
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

    @NonNull
    private List<School> zipDTOLists(
            final List<SchoolDTO> schoolDTOs, final List<SchoolSATDTO> satDTOs
    ) {
        try {
            return CollectionUtils.zip(schoolDTOs, satDTOs, this::hasSameId, School::from);
        } catch (final Throwable e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    private boolean hasSameId(
            @NonNull final SchoolDTO schooldto,
            @NonNull final SchoolSATDTO satdto) {
        return StringUtils.equalsIgnoreCase(schooldto.getId(), satdto.getId());
    }
}
