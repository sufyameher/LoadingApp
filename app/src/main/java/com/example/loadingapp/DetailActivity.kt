package com.example.loadingapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loadingapp.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val motionLayout = binding.motionLayout
//
//        motionLayout.transitionToEnd()
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, DetailActivity::class.java)
        }
    }
}




