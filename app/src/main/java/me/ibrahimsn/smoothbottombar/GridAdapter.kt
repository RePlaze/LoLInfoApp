package me.ibrahimsn.smoothbottombar

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.Filter
import android.widget.Filterable
import java.util.*

class GridAdapter(private val originalGridItems: List<GridItem>, private val context: Context) :
    RecyclerView.Adapter<GridAdapter.ViewHolder>(), Filterable {

    private var filteredGridItems: List<GridItem> = originalGridItems

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filteredGridItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return filteredGridItems.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (constraint.isNullOrEmpty()) {
                    filterResults.values = originalGridItems
                } else {
                    val filteredList = mutableListOf<GridItem>()
                    val filterPattern = constraint.toString().trim().toLowerCase(Locale.ROOT)
                    for (item in originalGridItems) {
                        if (item.name.toLowerCase(Locale.ROOT).contains(filterPattern)) {
                            filteredList.add(item)
                        }
                    }
                    filterResults.values = filteredList
                }
                return filterResults
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredGridItems = results?.values as? List<GridItem> ?: emptyList()
                notifyDataSetChanged()
            }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.itemName)
        private val imageView: ImageView = itemView.findViewById(R.id.itemImage)

        fun bind(item: GridItem) {
            nameTextView.text = item.name
            imageView.setImageResource(item.imageResId)
        }

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = filteredGridItems[position]
                    // Open ChampionInfo activity and pass the champion's name
                    val intent = Intent(context, ChampionInfo::class.java)
                    intent.putExtra("championName", item.name)
                    context.startActivity(intent)
                }
            }
        }
    }
}