package com.example.myhospitalapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myhospitalapp.ui.theme.MyHospitalAppTheme

class MainActivity : ComponentActivity() {

    lateinit var recyclerBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerBtn = findViewById(R.id.recyclerviewbtn)

        recyclerBtn.setOnClickListener{
            var intent = Intent(this, ServiceListActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

