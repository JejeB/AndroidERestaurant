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


      

    }