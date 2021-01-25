package fr.isen.bonnefoi.androiderestaurant

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
    }
    fun PlatCallBack(view: View?){
        val mytoast = Toast.makeText(this.applicationContext,"PlatCallBack",Toast.LENGTH_SHORT)
        mytoast.show()
    }
    fun DessertCallBack(view: View?){
        val mytoast = Toast.makeText(this.applicationContext,"Dessert",Toast.LENGTH_SHORT)
        mytoast.show()
    }

}
