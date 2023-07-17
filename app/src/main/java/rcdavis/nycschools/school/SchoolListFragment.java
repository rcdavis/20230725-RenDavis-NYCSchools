package rcdavis.nycschools.school;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import rcdavis.nycschools.BaseFragment;
import rcdavis.nycschools.R;
import rcdavis.nycschools.databinding.FragmentSchoolListBinding;

/**
 * A fragment representing a list of Items. This fragment
 * has different presentations for handset and larger screen devices. On
 * handsets, the fragment presents a list of items, which when touched,
 * lead to a {@link SchoolDetailFragment} representing
 * item details. On larger screens, the Navigation controller presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class SchoolListFragment extends BaseFragment<SchoolViewModel, FragmentSchoolListBinding> {
    @Override
    protected Class<SchoolViewModel> getViewModelClass() {
        return SchoolViewModel.class;
    }

    @Override
    protected FragmentSchoolListBinding createViewBinding(
            @NonNull LayoutInflater inflater, ViewGroup container
    ) {
        return FragmentSchoolListBinding.inflate(inflater, container, false);
    }

    @Override
    protected void onInit(Bundle savedInstanceState) {
        final SchoolRecyclerViewAdapter adapter = new SchoolRecyclerViewAdapter();
        binding.itemList.setAdapter(adapter);

        addDisposable(viewModel.getUIState().subscribe(uiState -> {
            if (uiState.getError() != null) {
                onError(uiState.getError());
            } else {
                adapter.setItems(uiState.getSchools());
            }
        }));

        adapter.onViewClicked()
                .subscribe(clickedView -> onClickView(clickedView.view, clickedView.item));
    }

    private void onClickView(final View view, final School school) {
        viewModel.updateSelectedSchool(school);
        if (binding.itemDetailNavContainer != null) {
            Navigation.findNavController(binding.itemDetailNavContainer)
                    .navigate(R.id.fragment_item_detail);
        } else {
            Navigation.findNavController(view).navigate(R.id.show_item_detail);
        }
    }

    private void onError(@NonNull final Throwable error) {
        error.printStackTrace();
        Toast.makeText(getContext(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        // TODO: Display error in UI
    }
}
