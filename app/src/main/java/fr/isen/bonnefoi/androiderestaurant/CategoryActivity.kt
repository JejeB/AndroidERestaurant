package fr.isen.bonnefoi.androiderestaurant

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class CategoryActivity: AppCompatActivity() {
    var category :String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_layout)
        this.category = intent.getStringExtra("title");
        var helloTextView = findViewById<TextView>(R.id.titleEntre);
        helloTextView.text = this.category;
    }
    private fun getFoodList() : List<Item>{
        var ret : List<Item> = emptyList()
        val queue = Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val params = JSONObject()
        params.put("id_shop", "1")

        // Request a string response from the provided URL.
        val stringRequest = JsonObjectRequest(Request.Method.POST, url,params,
                Response.Listener<JSONObject> { response ->
                    Log.i("json","Response is: $response")
                    val gson = Gson()
                    val json = gson.fromJson(response.toString(),FoodDataJSON::class.java)
                    Log.d("test",""+json)

                    when(category){
                        "Entrées" -> ret = getAllFoodItems(json.data[0])
                        "Plats" -> ret = getAllFoodItems(json.data[1])
                        "Desserts" -> ret = getAllFoodItems(json.data[2])
                    }
                    binding.listCategory.adapter = CategoryListAdapter(ret)
                    setContentView(binding.root)
                },
                Response.ErrorListener {
                    Log.i("test","request failed")
                }
        )

        // Add the request to the RequestQueue.
        queue.add(stringRequest)

        Log.d("ty",""+ret)
        re


    }