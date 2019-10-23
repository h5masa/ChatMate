package com.masa.chatmate.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.masa.chatmate.R
import kotlinx.android.synthetic.main.activity_register.*
import java.lang.Exception

class RegisterActivity : SuperActivity(R.layout.activity_register), View.OnClickListener {

    private final val TAG = "RegisterActivity"
    private lateinit var email: String
    private lateinit var password: String

    override fun MainBody() {
        register_button.setOnClickListener(this)
        haveaccount_lable.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.register_button -> {
                DoRegister()
            }

            R.id.haveaccount_lable -> {
                try {
                    NavigateToLoginpage()
                } catch (e: Exception) {
                    ShowErrorMessage(e)
                }
            }

        }
    }


    private fun DoRegister(){
        email = email_edittext.text.toString()
        password = password_edittext.text.toString()
        //Log.d(TAG, "Email: $email , Password: $password")

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Email/Password is not Completed",Toast.LENGTH_SHORT).show()
            return
        }

        //Firebase Authentication to create a account with email & password
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) {
                    return@addOnCompleteListener
                }else {
                    Log.d(TAG, "${it.result?.user?.uid}")
                }
            }.addOnFailureListener{
                Toast.makeText(this, it.message ,Toast.LENGTH_SHORT).show()
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


