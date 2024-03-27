package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val increaseSizeButton = findViewById<Button>(R.id.increaseSizeButton)
        val changeColorButton = findViewById<Button>(R.id.changeColorButton)

        increaseSizeButton.setOnClickListener {
            // Get the current text size in pixels
            val currentSizeInPixels = textView.textSize

            // Convert pixels to sp for readability and manipulation
            val currentSizeInSp = currentSizeInPixels / resources.displayMetrics.scaledDensity

            // Define the amount by which to increase the text size each time
            val increaseAmount = 2f // Increase by 2sp each time

            // Set a maximum text size limit to prevent it from becoming too large
            val maxSize = 32f// Maximum size in sp

            // Calculate the new desired size
            var newSizeInSp = currentSizeInSp + increaseAmount

            // Check if the new size exceeds the maximum allowed size
            if (newSizeInSp > maxSize) {
                // Optional: Reset to a smaller size or keep at maxSize
                // newSizeInSp = 12 // Reset to 12sp, for example
                newSizeInSp = maxSize // Or keep at maxSize
            }

            // Apply the new size to the textView
            textView.textSize = newSizeInSp
        }


        changeColorButton.setOnClickListener {
            // Generate a random color
            val randomColor = Color.rgb(
                Random.nextInt(256), // Red component
                Random.nextInt(256), // Green component
                Random.nextInt(256)  // Blue component
            )
            // Set the random color as the text color
            textView.setTextColor(randomColor)
        }
    }
}
