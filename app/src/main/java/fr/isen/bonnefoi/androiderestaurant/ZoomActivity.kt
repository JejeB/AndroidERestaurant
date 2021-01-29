package fr.isen.bonnefoi.androiderestaurant

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import fr.isen.bonnefoi.androiderestaurant.model.Item

class ZoomActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.zoom_layout)
        var platText = findViewById<TextView>(R.id.nom_plat)
        var ingtext = findViewById<TextView>(R.id.ingredients)
        var images = findViewById<ViewPager>(R.id.imageCarousel)

        ingtext.text = intent.getStringExtra("listIngredients");
        val mBundle = intent.extras



        if (mBundle != null) {
            mBundle.getSerializable("Desc").let { serializedItem ->
                val plat = serializedItem as Item
                platText.text = plat.name_fr

                val mViewPagerAdapter = CaroselAdpatater(applicationContext, plat.images)
                images!!.adapter = mViewPagerAdapter
            }
        }
    }
}