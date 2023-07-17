package rcdavis.nycschools.school;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class SchoolRepository {
    private final SchoolLocalDataSource mLocalDataSource;
    private final SchoolRemoteDataSource mRemoteDataSource;

    public SchoolRepository() {
        mLocalDataSource = new SchoolLocalDataSource();
        mRemoteDataSource = new SchoolRemoteDataSource();
    }

    public SchoolRepository(
            SchoolLocalDataSource localDataSource,
            SchoolRemoteDataSource remoteDataSource
    ) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    public Observable<List<School>> getAllSchools() {
        return mLocalDataSource.getAllSchools()
                .onErrorResumeWith(
                        mRemoteDataSource.getAllSchools()
                                .doOnNext(mLocalDataSource::setSchools)
                );
    }
}
