package fr.isen.bonnefoi.androiderestaurant

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import com.google.gson.GsonBuilder
import fr.isen.bonnefoi.androiderestaurant.model.Data

class CategoryActivity: AppCompatActivity() {
    var category :String? = ""
    private var catnumber:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_layout)
        this.category = intent.getStringExtra("title");
        var helloTextView = findViewById<TextView>(R.id.titleEntre);
        helloTextView.text = this.category;
        when(category){
            "Entrées" -> this.catnumber = 0
            "Plats" -> this.catnumber = 1
            "Desserts" -> this.catnumber = 2
        }

        getData()
    }
    private fun getData() {

        val parameter = JSONObject()
        val url = "http://test.api.catering.bluecodegames.com/menu"
        parameter.put("id_shop", "1")
        val requestQueue = Volley.newRequestQueue(this)
        val parser = GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()
        lateinit var dataRecycler:Data

        val jsonObjectRequest =
                JsonObjectRequest(Request.Method.POST, url, parameter, Response.Listener<JSONObject> { response ->
                    val rep = parser.fromJson(response["data"].toString(), Array<Data>::class.java)
                   dataRecycler = rep[this.catnumber];
                    //System.out.println(this.CAT)
                    Log.i("json","Response is: $response")
                    val foodRecycler = findViewById<RecyclerView>(R.id.Recycle)
                    foodRecycler.adapter = CategoryAdaptater(dataRecycler.items)
                    foodRecycler.layoutManager = LinearLayoutManager(this)

                    foodRecycler.isVisible = true
                },
                        Response.ErrorListener { error -> System.err.println( "Error: ${error.message}")
                        })

        requestQueue.add(jsonObjectRequest)

    }
}


