package rcdavis.nycschools.school;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class SchoolRepository {
    private final SchoolLocalDataSource localDataSource;
    private final SchoolRemoteDataSource remoteDataSource;

    public SchoolRepository() {
        localDataSource = new SchoolLocalDataSource();
        remoteDataSource = new SchoolRemoteDataSource();
    }

    public SchoolRepository(
            SchoolLocalDataSource localDataSource,
            SchoolRemoteDataSource remoteDataSource
    ) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public Observable<List<School>> getAllSchools() {
        return localDataSource.getAllSchools()
                .onErrorResumeWith(
                        remoteDataSource.getAllSchools()
                                .doOnNext(localDataSource::setSchools)
                );
    }
}
