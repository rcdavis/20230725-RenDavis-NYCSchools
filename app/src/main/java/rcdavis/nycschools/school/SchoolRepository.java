package rcdavis.nycschools.school;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import rcdavis.nycschools.util.MockData;

public class SchoolRepository {
    private final SchoolLocalDataSource mLocalDataSource = new SchoolLocalDataSource();

    public Observable<List<School>> getAllSchools() {
        return mLocalDataSource.getAllSchools()
                .onErrorReturnItem(MockData.getSchools())
                .doOnNext(mLocalDataSource::setSchools);
    }
}
