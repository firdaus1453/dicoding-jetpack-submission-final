package com.anangkur.madesubmission1.feature.main.tv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anangkur.madesubmission1.R
import com.anangkur.madesubmission1.data.model.Result
import com.anangkur.madesubmission1.feature.main.movie.MovieItemListener
import com.anangkur.madesubmission1.utils.Const
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_main_horizontal_landscape.view.*

class TvAdapter(private val movieItemListener: MovieItemListener): RecyclerView.Adapter<TvAdapter.ViewHolder>() {

    private val items = ArrayList<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main_horizontal_landscape, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setRecyclerData(data: List<Result>){
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(data: Result){
            itemView.tv_title.text = data.original_title
            Glide.with(itemView.context)
                .load("${Const.baseImageUrl}${data.backdrop_path}")
                .apply(RequestOptions().centerCrop())
                .into(itemView.iv_item)
            itemView.setOnClickListener { movieItemListener.onClickItem(data) }
        }
    }
}