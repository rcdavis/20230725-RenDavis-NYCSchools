package rcdavis.nycschools;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import rcdavis.nycschools.school.Address;

public abstract class BaseFragment<V extends ViewModel, B extends ViewBinding> extends Fragment {
    protected V viewModel;
    protected B binding;

    private final CompositeDisposable mDisposables = new CompositeDisposable();

    protected void addDisposable(final Disposable disposable) {
        mDisposables.add(disposable);
    }

    @Override
    public View onCreateView(
        @NonNull LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState
    ) {
        binding = createViewBinding(inflater, container);
        viewModel = new ViewModelProvider(requireActivity()).get(getViewModelClass());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onInit(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mDisposables.clear();
        binding = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mDisposables.dispose();
    }

    protected abstract Class<V> getViewModelClass();

    protected abstract B createViewBinding(@NonNull LayoutInflater inflater, ViewGroup container);

    protected abstract void onInit(Bundle savedInstanceState);

    protected void launchMapApp(@NonNull final Address address) {
        final Intent intent = new Intent(Intent.ACTION_VIEW, address.getMapUri());
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}
