package com.masa.chatmate.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masa.chatmate.R

open abstract class SuperActivity(val layoutid:Int) : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(this.layoutid)
        MainBody()
    }

    abstract fun MainBody()
}
