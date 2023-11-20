package com.sliderzxc.hydrogen.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sliderzxc.hydrogen.hydrogen
import com.sliderzxc.hydrogen.requests.get.get

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hydro = hydrogen()
        val a = hydro.get<Unit> {
            url = "dsdsds"
        }
    }
}