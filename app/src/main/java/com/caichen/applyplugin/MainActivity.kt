package com.caichen.applyplugin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.caichen.router_annotations.Router

@Router(url = "router://main",description = "主页")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}