package com.example.rick_morty_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rick_morty_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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

