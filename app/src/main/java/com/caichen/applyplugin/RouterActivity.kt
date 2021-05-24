package com.caichen.applyplugin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.caichen.router_annotations.Router

@Router(url = "router://router",description = "路由")
class RouterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_router)
    }
}