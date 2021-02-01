package fr.isen.bonnefoi.androiderestaurant

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.NumberPicker
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso
import java.util.*

class CaroselAdpatater(context: Context, images: List<String>): PagerAdapter() {
    var layout: LayoutInflater = LayoutInflater.from(context)
    var context: Context = context
    var images: List<String> = images
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun getCount(): Int {
        return images.size
    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val itemView: View = layout.inflate(R.layout.img_layout, container, false)
        val imageView: ImageView = itemView.findViewById<ImageView>(R.id.imageLayout)


        val pablo = Picasso.get()
        if(images[position].isNotEmpty()){
            pablo.load(images[position]).into(imageView)
        }


        Objects.requireNonNull(container).addView(itemView)
        return itemView
    }
    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        container.removeView(`object` as LinearLayout)
    }

}