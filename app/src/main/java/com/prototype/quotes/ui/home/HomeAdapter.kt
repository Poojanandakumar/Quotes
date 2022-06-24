package com.prototype.quotes.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prototype.model.QuotesData
import com.prototype.quotes.R

class HomeAdapter(
    private val mList: List<QuotesData.Result>, private val viewModel: HomeViewModel
) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView.findViewById(R.id.content)
        val author: TextView = itemView.findViewById(R.id.author)
        val star: ImageView = itemView.findViewById(R.id.star)
        val filledStar: ImageView = itemView.findViewById(R.id.star_filled)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.quotes, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content = mList[position].content
        val author = mList[position].author
        holder.content.text = content
        holder.author.text = "~ $author"

        val star = holder.star
        val filledStar = holder.filledStar
        star.setOnClickListener {
            filledStar.visibility = View.VISIBLE
            star.visibility = View.INVISIBLE
            viewModel.addToFavourite(content, author)
        }
        filledStar.setOnClickListener {
            star.visibility = View.VISIBLE
            filledStar.visibility = View.INVISIBLE
            viewModel.deleteFormFavourite(content,author)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}