package com.example.loadingapp

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.loadingapp.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var loadingButton: LoadingButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadingButton = binding.loadingButton

        binding.startDownloadButton.setOnClickListener {
            onStartDownloadButtonClick()
        }

    }
    private fun onStartDownloadButtonClick() {
        val selectedRepositoryId = binding.repositoryRadioGroup.checkedRadioButtonId
        val selectedRepository = findViewById<RadioButton>(selectedRepositoryId)?.text.toString()

        binding.loadingButton.startLoading()

        binding.loadingButton.postDelayed({
            // Simulate download completion
            binding.loadingButton.completeLoading()

            showToast("Downloading from $selectedRepository repository")

        }, 3000)
    }

    private fun showToast(message: String) {
        // Display a toast message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
