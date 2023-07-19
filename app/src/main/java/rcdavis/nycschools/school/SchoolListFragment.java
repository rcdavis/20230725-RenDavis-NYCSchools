package rcdavis.nycschools.school;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import java.util.ArrayList;

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
    private SchoolRecyclerViewAdapter adapter;

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
        adapter = new SchoolRecyclerViewAdapter();
        binding.itemList.setAdapter(adapter);

        addDisposable(viewModel.getUIState().subscribe(uiState -> {
            if (uiState instanceof SchoolLoadingUIState) {
                onLoadingList((SchoolLoadingUIState) uiState);
            } else if (uiState instanceof SchoolErrorUIState) {
                onError((SchoolErrorUIState) uiState);
            } else if (uiState instanceof SchoolListUIState) {
                onSchoolList((SchoolListUIState) uiState);
            } else if (uiState instanceof SchoolEmptyListUIState) {
                onEmptyList((SchoolEmptyListUIState) uiState);
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

    private void onLoadingList(final SchoolLoadingUIState uiState) {
        binding.msgText.setText(R.string.loading_schools);
        binding.msgText.setVisibility(View.VISIBLE);
    }

    private void onSchoolList(@NonNull final SchoolListUIState uiState) {
        binding.msgText.setVisibility(View.GONE);
        adapter.setItems(uiState.getSchools());
    }

    private void onEmptyList(final SchoolEmptyListUIState uiState) {
        binding.msgText.setText(R.string.empty_schools_list);
        binding.msgText.setVisibility(View.VISIBLE);
        adapter.setItems(new ArrayList<>());
    }

    private void onError(@NonNull final SchoolErrorUIState uiState) {
        binding.msgText.setText(uiState.getError().getLocalizedMessage());
        binding.msgText.setVisibility(View.VISIBLE);
        uiState.getError().printStackTrace();
    }
}
