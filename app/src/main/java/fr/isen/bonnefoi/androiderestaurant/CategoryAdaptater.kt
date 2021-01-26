package fr.isen.bonnefoi.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdaptater(private val foods : List<Item>) : RecyclerView.Adapter<CategoryAdaptater.CategoryHolder>() {
    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ):CategoryHolder {
        return CategoryHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_layout, parent, false))
    }

    override fun getItemCount(): Int = foods.size

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.title.text = foods[position].nom

    }

    class CategoryHolder(view : View) : RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.titleEntre)
    }

}