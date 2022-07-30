package com.kryak.appselect_test_task.presenter.mainList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.google.android.material.textview.MaterialTextView
import com.kryak.appselect_test_task.R
import com.kryak.appselect_test_task.data.dto.Result
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MovieAdapter :
    PagingDataAdapter<Result, RecyclerView.ViewHolder>(Movie_Comp) {

    companion object {
        private val Movie_Comp = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result) =
                oldItem.displayTitle == newItem.displayTitle

            override fun areContentsTheSame(oldItem: Result, newItem: Result) =
                oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let { (holder as? MoviesViewHolder)?.bind(item = it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MoviesViewHolder.getInstance(parent)
    }
}

class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {

        fun getInstance(parent: ViewGroup): MoviesViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.rv_item, parent, false)
            return MoviesViewHolder(view)
        }
    }

    var rv_item_imageview: ImageView = view.findViewById(R.id.rv_item_imageview)
    var rv_item_title: MaterialTextView = view.findViewById(R.id.rv_item_title)
    var rv_item_summary: MaterialTextView = view.findViewById(R.id.rv_item_summary)
    var rv_byline: MaterialTextView = view.findViewById(R.id.rv_item_byLine)

    @Inject
    lateinit var context: ApplicationContext

    fun bind(item: Result) {
        rv_item_imageview.load(item.multimedia.src) {
            size(item.multimedia.width, item.multimedia.height)
        }
        rv_item_title.text = item.displayTitle
        rv_item_summary.text = item.summaryShort
        rv_byline.text = item.byline
    }
}
