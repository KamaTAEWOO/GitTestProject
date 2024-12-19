package com.example.aproject

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 버튼 클릭 시 B 앱의 MainActivity로 이동
        val button = findViewById<Button>(R.id.btnMove)
        button.setOnClickListener {
            val intent = Intent().apply {
                component = ComponentName(
                    "com.example.bproject",
                    "com.example.bproject.ui.settings.MainActivity"
                )
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }

            try {
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
                // 액티비티를 찾지 못한 경우 처리
                Toast.makeText(this, "${e.printStackTrace()}", Toast.LENGTH_SHORT).show()
            }

        }
    }
}