package rcdavis.nycschools.school;

import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SchoolViewModel extends ViewModel {
    private final SchoolRepository schoolRepository;

    private School selectedSchool;

    public SchoolViewModel() {
        schoolRepository = new SchoolRepository();
        selectedSchool = null;
    }

    public SchoolViewModel(final SchoolRepository repository) {
        schoolRepository = repository;
        selectedSchool = null;
    }

    public void updateSelectedSchool(final School school) {
        selectedSchool = school;
    }

    public Observable<School> getSelectedSchool() {
        if (selectedSchool == null)
            return Observable.error(new IllegalStateException("No School Selected"));

        return Observable.just(selectedSchool);
    }

    public Observable<SchoolUIState> getUIState() {
        return schoolRepository.getAllSchools()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(schools -> {
                    if (schools.isEmpty())
                        return SchoolUIState.emptyList();
                    else
                        return SchoolUIState.fromList(schools);
                })
                .startWithItem(SchoolUIState.loading())
                .onErrorReturn(SchoolUIState::fromError);
    }
}
