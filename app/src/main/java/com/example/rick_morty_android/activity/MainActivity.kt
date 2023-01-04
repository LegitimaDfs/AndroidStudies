package com.example.rick_morty_android.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rick_morty_android.model.Note
import com.example.rick_morty_android.NoteListAdapter
import com.example.rick_morty_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val fragmentManager = supportFragmentManager
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}

