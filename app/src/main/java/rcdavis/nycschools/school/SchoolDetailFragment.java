package rcdavis.nycschools.school;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import rcdavis.nycschools.BaseFragment;
import rcdavis.nycschools.databinding.FragmentSchoolDetailBinding;
import rcdavis.nycschools.util.MockData;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link SchoolListFragment}
 * in two-pane mode (on larger screen devices) or self-contained
 * on handsets.
 */
public class SchoolDetailFragment
        extends BaseFragment<SchoolViewModel, FragmentSchoolDetailBinding> {

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SchoolDetailFragment() {}

    @Override
    protected void onInit(Bundle savedInstanceState) {
        addDisposable(viewModel.getSelectedSchool()
                .onErrorReturn(e -> {
                    e.printStackTrace();
                    return MockData.getMockSchool();
                })
                .subscribe(school -> binding.setSchool(school)));
    }

    @Override
    protected Class<SchoolViewModel> getViewModelClass() {
        return SchoolViewModel.class;
    }

    @Override
    protected FragmentSchoolDetailBinding createViewBinding(
            @NonNull LayoutInflater inflater, ViewGroup container
    ) {
        return FragmentSchoolDetailBinding.inflate(inflater, container, false);
    }
}
