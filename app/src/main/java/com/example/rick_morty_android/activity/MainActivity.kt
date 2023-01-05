package com.example.rick_morty_android.activity

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.rick_morty_android.model.Note
import com.example.rick_morty_android.NoteListAdapter
import com.example.rick_morty_android.R
import com.example.rick_morty_android.databinding.ActivityMainBinding
import com.example.rick_morty_android.fragment.SelectedCharFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    fun onClickFirst(view: View) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.recyclerView, SelectedCharFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}

