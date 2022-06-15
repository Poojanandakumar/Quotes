package com.prototype.quotes.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prototype.quotes.R
import com.prototype.model.QuotesData

class HomeAdapter( private val mList: List<QuotesData.Result>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView.findViewById(R.id.content)
        val author:TextView = itemView.findViewById(R.id.author)
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
    }

    override fun getItemCount(): Int {
       return mList.size
    }
}