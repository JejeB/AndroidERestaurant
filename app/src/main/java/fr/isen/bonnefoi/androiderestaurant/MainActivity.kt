package fr.isen.bonnefoi.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun EntreCallBack(view: View?){
        val mytoast = Toast.makeText(this.applicationContext,"Entrées",Toast.LENGTH_SHORT)
        mytoast.show()
        startActivity(
            Intent(applicationContext, EntreeActivity::class.java)
        )
    }
    fun PlatCallBack(view: View?){
        val mytoast = Toast.makeText(this.applicationContext,"Plats",Toast.LENGTH_SHORT)
        mytoast.show()
        startActivity(
            Intent(applicationContext, PlatsActivity::class.java)
        )
    }
    fun DessertCallBack(view: View?){
        val mytoast = Toast.makeText(this.applicationContext,"Desserts",Toast.LENGTH_SHORT)
        mytoast.show()
        startActivity(
            Intent(applicationContext, DessertsActivity::class.java)
        )
    }

}
