package com.d121191042artiaaudrianaryatama.tugasfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.d121191042artiaaudrianaryatama.tugasfinal.UI.ListResepFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, ListResepFragment())
            .commitNow()
    }
}