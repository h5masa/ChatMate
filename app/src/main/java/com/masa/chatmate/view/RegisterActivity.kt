package com.masa.chatmate.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.masa.chatmate.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private final val TAG = "RegisterActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        register_button.setOnClickListener{it->
            val email = email_edittext.text.toString()
            val password = password_edittext.text.toString()

            Log.d(TAG, "Email: $email , Password: $password")
        }
    }
}
