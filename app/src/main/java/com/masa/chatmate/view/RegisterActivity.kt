package com.masa.chatmate.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.masa.chatmate.R
import kotlinx.android.synthetic.main.activity_register.*
import java.lang.Exception

class RegisterActivity : SuperActivity(R.layout.activity_register) {
    private final val TAG = "RegisterActivity"
    private lateinit var email: String
    private lateinit var password: String

    override fun MainBody() {
        register_button.setOnClickListener { it ->
            email = email_edittext.text.toString()
            password = password_edittext.text.toString()
            Log.d(TAG, "Email: $email , Password: $password")
        }

        haveaccount_lable.setOnClickListener {
            try {
                NavigateToLoginpage()
            } catch (e: Exception) {
                ShowErrorMessage(e)
            }
        }
    }

    @Throws
    private fun NavigateToLoginpage() {
        var intent: Intent? = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun ShowErrorMessage(e: Exception) {
        Toast.makeText(
            this,
            "Unexpected Error Occured. Check Error Message",
            Toast.LENGTH_SHORT
        ).show()
        Log.e("ERROR", "From $TAG: $e.toString()")
    }

}
