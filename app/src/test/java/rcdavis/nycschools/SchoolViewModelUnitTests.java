package rcdavis.nycschools;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;
import rcdavis.nycschools.school.School;
import rcdavis.nycschools.school.SchoolRepository;
import rcdavis.nycschools.school.SchoolUIState;
import rcdavis.nycschools.school.SchoolViewModel;

public class SchoolViewModelUnitTests {
    private SchoolViewModel viewModel;

    @Mock private SchoolRepository schoolRepository;

    @Rule
    public RxTrampolineSchedulerRule schedulersOverrideRule = new RxTrampolineSchedulerRule();

    @Before
    public void beforeEachTest() {
        try (final AutoCloseable ignored = MockitoAnnotations.openMocks(this)) {
            viewModel = new SchoolViewModel(schoolRepository);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenSchoolListIsEmpty_ThenReturnEmptyListUIState() {
        when(schoolRepository.getAllSchools())
                .thenReturn(Observable.just(new ArrayList<>()));

        final TestObserver<SchoolUIState> testObserver = viewModel.getUIState().test();
        testObserver.assertValueAt(0, SchoolUIState.loading());
        testObserver.assertValueAt(1, SchoolUIState.emptyList());
    }

    @Test
    public void whenSchoolListIsNotEmpty_ThenReturnListUIState() {
        final List<School> schools = TestUtils.createMockSchoolsList();

        when(schoolRepository.getAllSchools())
                .thenReturn(Observable.just(schools));

        final TestObserver<SchoolUIState> testObserver = viewModel.getUIState().test();
        testObserver.assertValueAt(0, SchoolUIState.loading());
        testObserver.assertValueAt(1, SchoolUIState.fromList(schools));
    }

    @Test
    public void whenSchoolListError_ThenReturnErrorUIState() {
        final Throwable e = new IllegalStateException("Failed to get schools");

        when(schoolRepository.getAllSchools())
                .thenReturn(Observable.error(e));

        final TestObserver<SchoolUIState> testObserver = viewModel.getUIState().test();
        testObserver.assertValueAt(0, SchoolUIState.loading());
        testObserver.assertValueAt(1, SchoolUIState.fromError(e));
    }
}
