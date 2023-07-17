package rcdavis.nycschools.school;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

import rcdavis.nycschools.BaseRecyclerViewAdapter;
import rcdavis.nycschools.databinding.SchoolListContentBinding;

public class SchoolRecyclerViewAdapter
        extends BaseRecyclerViewAdapter<School, SchoolListContentBinding> {

    public SchoolRecyclerViewAdapter() {
        super();
    }

    public SchoolRecyclerViewAdapter(final List<School> items) {
        super(items);
    }

    @Override
    protected SchoolListContentBinding createViewBinding(@NonNull ViewGroup parent) {
        return SchoolListContentBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
    }

    @Override
    protected void onBindItemToViewHolder(
            @NonNull ViewHolder<SchoolListContentBinding> holder, School item
    ) {
        holder.binding.setSchool(item);
    }
}
