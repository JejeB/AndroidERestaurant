package fr.isen.bonnefoi.androiderestaurant

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SingUpActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sing_layout)

    }

    fun commander(view: View?){
        val email = view?.findViewById<EditText>(R.id.email)
        val confirm_email = view?.findViewById<EditText>(R.id.emailconfirm)

        val pass = view?.findViewById<EditText>(R.id.pass)
        val confirm_pass = view?.findViewById<EditText>(R.id.passconfirm)

        var isTestOk = 0
        if (email?.text == confirm_email?.text){
            isTestOk=1
            if (pass?.text == confirm_pass?.text){
                isTestOk=1
            }else{
                Toast.makeText(this,"Les mots de passes ne sont pas identiques", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this,"Les adresses email ne sont pas identiques", Toast.LENGTH_SHORT).show()
        }

        if (isTestOk==1){
            Toast.makeText(this,"ok", Toast.LENGTH_SHORT).show()
        }

    }
}