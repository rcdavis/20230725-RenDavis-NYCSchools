package rcdavis.nycschools;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;
import rcdavis.nycschools.school.School;
import rcdavis.nycschools.school.SchoolAPI;
import rcdavis.nycschools.school.SchoolLocalDataSource;
import rcdavis.nycschools.school.SchoolRemoteDataSource;
import rcdavis.nycschools.school.SchoolRepository;

public class SchoolRepositoryUnitTests {
    private SchoolRepository schoolRepository;

    @Mock private SchoolLocalDataSource schoolLocalDataSource;
    @Mock private SchoolAPI schoolApi;

    @Before
    public void beforeEachTest() {
        try (final AutoCloseable ignored = MockitoAnnotations.openMocks(this)) {
            schoolRepository = new SchoolRepository(
                    schoolLocalDataSource,
                    new SchoolRemoteDataSource(schoolApi)
            );

            when(schoolApi.getAllSchools())
                    .thenReturn(Observable.just(TestUtils.createMockSchoolDtos()));
            when(schoolApi.getAllSATScores())
                    .thenReturn(Observable.just(TestUtils.createMockSatDtos()));
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenLocalSchoolIsEmpty_ThenCallWebApi() {
        final List<School> schools = TestUtils.createMockSchoolsList();
        when(schoolLocalDataSource.getAllSchools()).thenReturn(
                Observable.error(new IllegalStateException("Couldn't get stored schools"))
        );

        final TestObserver<List<School>> testObserver = schoolRepository.getAllSchools().test();
        testObserver.assertResult(schools);

        verify(schoolLocalDataSource, times(1)).getAllSchools();
        verify(schoolApi, times(1)).getAllSchools();
        verify(schoolApi, times(1)).getAllSATScores();
    }

    @Test
    public void whenLocalSchoolsNotEmpty_ThenReturnLocal() {
        final List<School> schools = TestUtils.createMockSchoolsList();
        when(schoolLocalDataSource.getAllSchools())
                .thenReturn(Observable.just(schools));

        final TestObserver<List<School>> testObserver = schoolRepository.getAllSchools().test();
        testObserver.assertResult(schools);

        verify(schoolLocalDataSource, times(1)).getAllSchools();
    }
}
