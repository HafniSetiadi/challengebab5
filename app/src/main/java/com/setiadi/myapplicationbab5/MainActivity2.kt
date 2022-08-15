package com.setiadi.myapplicationbab5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.setiadi.myapplicationbab5.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private var layout: ActivityMain2Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        layout = ActivityMain2Binding.inflate(layoutInflater)

        setContentView(layout?.root)

        layout?.btnPlay?.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivitySuit::class.java)
            startActivity(intent)
        }

        val snackbar = layout?.root?.let { Snackbar.make(this,
            it, "Selamat Datang", Snackbar.LENGTH_INDEFINITE)
        }
        snackbar?.setAction("Tutup") {
            snackbar.dismiss()
        }
        snackbar?.show()
        }
    }
