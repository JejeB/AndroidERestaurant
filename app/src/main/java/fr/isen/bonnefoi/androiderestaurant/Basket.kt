package fr.isen.bonnefoi.androiderestaurant

import android.content.Context
import com.google.gson.GsonBuilder
import fr.isen.bonnefoi.androiderestaurant.model.Data
import fr.isen.bonnefoi.androiderestaurant.model.Item
import java.io.File
import java.io.Serializable

class Basket (val items: MutableList<BasketItem>): Serializable {

    var nbItems: Int = 0
        get() {
            return if(items.count() > 0) {
                items
                        .map { it.count }
                        .reduce { acc, i -> acc + i }
            } else {
                0
            }
        }

    fun addItem(item: BasketItem) {
        val existingItem = items.firstOrNull {
            it.data.name_fr == item.data.name_fr
        }
        existingItem?.let {
            existingItem.count += item.count
        } ?: run {
            items.add(item)
        }
    }

    fun save(context: Context) {
        val jsonFile = File(context.cacheDir.absolutePath + BASKET_FILE)
        jsonFile.writeText(GsonBuilder().create().toJson(this))

    }

    companion object {

        fun getBasket(context: Context): Basket {
            val file = File(context.cacheDir.absolutePath + BASKET_FILE)

            if(file.exists()) {
                val json = file.readText()
                return GsonBuilder().create().fromJson(json, Basket::class.java)
            } else {
                return Basket(mutableListOf())
            }
        }
        const val BASKET_FILE = "basket.json"
    }
}

class BasketItem(val data: Item, var count: Int): Serializable {}