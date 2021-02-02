package fr.isen.bonnefoi.androiderestaurant

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.bonnefoi.androiderestaurant.model.Item

class BasketApapter(val items: MutableList<BasketItem>,private val context: Context) : RecyclerView.Adapter<BasketApapter.BasketHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketApapter.BasketHolder {
        return BasketApapter.BasketHolder(LayoutInflater.from(parent.context).inflate(R.layout.basket_card_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BasketApapter.BasketHolder, position: Int) {
        val item = items[position].data
        val pablo = Picasso.get()
        if(item.images[0].isNotEmpty()){
            pablo.load(item.images[0]).into(holder.imagePlat)
        }
        holder.title.text= item.name_fr
        holder.nb.text = items[position].count.toString()
    }
    class BasketHolder(view : View) : RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.nom_plat)
        val imagePlat = view.findViewById<ImageView>(R.id.imageView_item)
        val card: CardView = view.findViewById(R.id.cardView)
        val nb= view.findViewById<TextView>(R.id.nbCmd)
    }
}