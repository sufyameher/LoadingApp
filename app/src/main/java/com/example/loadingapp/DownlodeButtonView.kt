package com.example.loadingapp

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.loadingapp.databinding.DownloadButtonLayoutBinding

class DownloadButtonView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: DownloadButtonLayoutBinding =
        DownloadButtonLayoutBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        orientation = VERTICAL
        setupListeners()
    }

    private fun setupListeners() {
        setOnClickListener {
            // Simulate download initiation
            startDownload()
        }
    }

    private fun startDownload() {
        // Change button state to "Downloading"
        binding.buttonText.text = "Downloading"
        binding.progressBar.visibility = VISIBLE
        binding.circularProgressBar.visibility = VISIBLE
        binding.progressBar.animate().alpha(1f).setDuration(500).start()
        binding.circularProgressBar.animate().rotationBy(360f).setDuration(1000).start()

        // Simulate download completion after 3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            // Change button state to "Download Complete"
            binding.buttonText.text = "Download Complete"
            binding.progressBar.animate().alpha(0f).setDuration(500).start()
            binding.circularProgressBar.animate().rotationBy(360f).setDuration(1000).start()

            // Send notification
            sendNotification()

        }, 3000)
    }

    private fun sendNotification() {
        val notificationHelper = NotificationHelper(context.applicationContext)
        notificationHelper.showNotification("Download Complete", "Click to view details")
    }
}

