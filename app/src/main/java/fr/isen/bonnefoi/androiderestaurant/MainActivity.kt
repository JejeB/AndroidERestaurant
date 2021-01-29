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
        val mytoast = Toast.makeText(this,"Entrées",Toast.LENGTH_SHORT)
        mytoast.show()
        startActivity(
            Intent(this, CategoryActivity::class.java).putExtra("title","Entrées")
        )
    }
    fun PlatCallBack(view: View?){
        val mytoast = Toast.makeText(this,"Plats",Toast.LENGTH_SHORT)
        mytoast.show()
        startActivity(
                Intent(this, CategoryActivity::class.java).putExtra("title","Plats")
        )
    }
    fun DessertCallBack(view: View?){
        val mytoast = Toast.makeText(this,"Desserts",Toast.LENGTH_SHORT)
        mytoast.show()
        startActivity(
                Intent(this, CategoryActivity::class.java).putExtra("title","Desserts")
        )
    }

}
