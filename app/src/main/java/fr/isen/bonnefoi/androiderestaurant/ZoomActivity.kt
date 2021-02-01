package fr.isen.bonnefoi.androiderestaurant

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.NumberPicker
import android.widget.NumberPicker.OnValueChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import fr.isen.bonnefoi.androiderestaurant.model.Item

class ZoomActivity: AppCompatActivity() {
    private lateinit var numberPick :NumberPicker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.zoom_layout)
        var platText = findViewById<TextView>(R.id.nom_plat)
        var ingtext = findViewById<TextView>(R.id.ingredients)
        var images = findViewById<ViewPager>(R.id.imageCarousel)
         numberPick = findViewById<NumberPicker>(R.id.number_picker)


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
        numberPick.minValue = 1
        numberPick.maxValue = 20


    }

    fun commandeCallBack(view: View?){
        val mytoast = Toast.makeText(this,"${numberPick.value}",Toast.LENGTH_SHORT)
        mytoast.show()
    }
}