package fr.isen.bonnefoi.androiderestaurant

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.bonnefoi.androiderestaurant.model.Item

class CategoryAdaptater(private val foods : List<Item>,private val context: Context) : RecyclerView.Adapter<CategoryAdaptater.CategoryHolder>() {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ):CategoryHolder {
        return CategoryHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false))
    }

    override fun getItemCount(): Int = foods.size

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val plat = foods[position]
        val pablo = Picasso.get()
        val ingredients = plat.ingredients


        val pr :StringBuilder = StringBuilder("")
        for (content in ingredients){ pr.append(content.name_fr+", ") }

        holder.ingredient.text =pr.toString()
        holder.title.text = plat.name_fr

        if(plat.images[0].isNotEmpty()){
            pablo.load(plat.images[0]).into(holder.imagePlat)
        }
        val card = holder.card
        card.setOnClickListener {

            val intent = Intent(context, ZoomActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("Desc", plat)
            intent.putExtra("listIngredients",pr.toString())
            context.startActivity(intent)
        }

    }

    class CategoryHolder(view : View) : RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.nom_plat)
        val imagePlat = view.findViewById<ImageView>(R.id.imageView_item)
        val ingredient = view.findViewById<TextView>(R.id.ingredients)
        val card: CardView = view.findViewById(R.id.cardView)
    }
}