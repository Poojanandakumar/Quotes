package com.prototype.quotes.ui.favourite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prototype.model.QuotesData
import com.prototype.quotes.R
import com.prototype.quotes.ui.home.HomeViewModel
import com.prototype.shared.room.FavouriteQuoteEntity
import java.nio.file.Files.delete

class FavouriteQuotesAdapter(
    private val mList: List<FavouriteQuoteEntity>,
    private val viewModel: FavouriteViewModel
) : RecyclerView.Adapter<FavouriteQuotesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView.findViewById(R.id.content)
        val author: TextView = itemView.findViewById(R.id.author)
        val delete: ImageView = itemView.findViewById(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.favourite_quotes, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content = mList[position].quote
        val author = mList[position].author
        holder.content.text = content
        holder.author.text = "~ $author"

        holder.delete.setOnClickListener {
            viewModel.deleteFormFavourite(content, author)
            viewModel.getFavouriteQuotes()
        }
    }
}