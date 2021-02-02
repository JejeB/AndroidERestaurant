package fr.isen.bonnefoi.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.isen.bonnefoi.androiderestaurant.model.Price


class BasketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basket_layout)

        val recycler = findViewById<RecyclerView>(R.id.RecycleBasket)
        var button = findViewById<Button>(R.id.button)
        val basket = Basket.getBasket(this)
        Log.i("Basket","le panier : ${basket.items[0]}")
        recycler.adapter = BasketApapter(basket.items,this)
        recycler.layoutManager = LinearLayoutManager(this)

        recycler.isVisible = true
        var totalPrice= 0
        for (item in basket.items){
            totalPrice = item.count * item.data.prices[0].price.toInt()
        }
        button.text = "Commandez $totalPrice $"

    }
    fun launchSing(view: View?){
        startActivity(
                Intent(this, SingUpActivity::class.java)
        )
    }
}