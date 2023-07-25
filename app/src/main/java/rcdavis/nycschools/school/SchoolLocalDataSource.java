package rcdavis.nycschools.school;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class SchoolLocalDataSource {
    private List<School> schools = new ArrayList<>();

    public Observable<List<School>> getAllSchools() {
        if (schools.isEmpty())
            return Observable.error(new IllegalStateException("Couldn't get stored schools"));

        return Observable.just(schools);
    }

    public void setSchools(final List<School> schools) {
        this.schools = schools;
    }
}
