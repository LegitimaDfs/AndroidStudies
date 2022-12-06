package com.example.rick_morty_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.rick_morty_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val note = listOf(
            Note(
                image = "",
                texto = "Rick",
                descricao = "Um cientista maluco"
            ),
            Note(
                image = "",
                texto = "Rick",
                descricao = "Um cientista maluco"
            )

        )
        setupAdapter(binding, note)
    }

    private fun setupAdapter(binding: ActivityMainBinding, listNote: List<Note>) {
        binding.recyclerView.adapter = NoteListAdapter(listNote)
    }

}

