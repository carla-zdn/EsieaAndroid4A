package com.example.esieaandroid4a.presentation.recyclerView

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.esieaandroid4a.R
import com.example.esieaandroid4a.domain.entity.User
import org.koin.android.ext.android.inject

class SecondActivity : SingleFragmentActivity(){

    override fun createFragment() = MainFragment.newInstance()
}
