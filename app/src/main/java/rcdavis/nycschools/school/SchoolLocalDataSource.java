package rcdavis.nycschools.school;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class SchoolLocalDataSource {
    private List<School> mSchools = new ArrayList<>();

    public Observable<List<School>> getAllSchools() {
        if (mSchools.isEmpty())
            return Observable.error(new IllegalStateException("Couldn't get stored schools"));

        return Observable.just(mSchools);
    }

    public void setSchools(final List<School> schools) {
        mSchools = schools;
    }
}
