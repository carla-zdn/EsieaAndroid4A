package com.example.esieaandroid4a.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.esieaandroid4a.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_button.setOnClickListener {
            mainViewModel.onClickedIncrement()
        }

        mainViewModel.counter.observe(this, {
            main_text.text = it.toString()
        })
    }
}