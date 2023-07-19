package rcdavis.nycschools

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.jakewharton.rxbinding.view.RxView
import rx.Observable
import rx.subjects.PublishSubject

abstract class BaseRecyclerViewAdapter<T, B: ViewBinding>(
    private var items: List<T> = listOf()
): RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder<B>>() {

    class ViewHolder<B: ViewBinding>(val binding: B): RecyclerView.ViewHolder(binding.root)
    inner class ClickedView(val view: View, val item: T)

    private val viewClickSubject = PublishSubject.create<ClickedView>()
    fun onViewClicked(): Observable<ClickedView> = viewClickSubject

    protected abstract fun createViewBinding(parent: ViewGroup): B

    protected abstract fun onBindItemToViewHolder(holder: ViewHolder<B>, item: T)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<B> {
        return ViewHolder(createViewBinding(parent))
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        viewClickSubject.onCompleted()
    }

    override fun onBindViewHolder(holder: ViewHolder<B>, position: Int) {
        RxView.clicks(holder.itemView)
            .map { ClickedView(holder.itemView, items[position]) }
            .subscribe(viewClickSubject)

        onBindItemToViewHolder(holder, items[position])
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearItems() {
        items = listOf()
        notifyDataSetChanged()
    }
}
