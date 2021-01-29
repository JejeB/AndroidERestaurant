package fr.isen.bonnefoi.androiderestaurant

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
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
        // inflating
        val itemView: View = layout.inflate(R.layout.img_layout, container, false)

        // referencing the image view from the item.xml file
        val imageView: ImageView = itemView.findViewById<ImageView>(R.id.imageLayout)


        // setting the image in the imageView
        val picasso = Picasso.get()
        if(images[position].isNotEmpty()){
            picasso.load(images[position]).into(imageView)
        }

        // Adding the View
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