package com.example.rick_morty_android.fragment

import android.content.ClipData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.fragment.findNavController
import com.example.rick_morty_android.NoteListAdapter
import com.example.rick_morty_android.R
import com.example.rick_morty_android.databinding.ActivityMainBinding
import com.example.rick_morty_android.databinding.FragmentCharacterBinding
import com.example.rick_morty_android.model.Note


class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding

    override fun onCreateView(
        //Responsável por criar a hierarquia de visualização de cada fragment
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Momento que o usuário vê a tela
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        val note = listOf(
            Note(
                image = "",
                titulo = "Rick",
                descricao = "Um cientista maluco"
            ),
            Note(
                image = "",
                titulo = "Morty",
                descricao = "Uma criança problematica"
            )

        )
        setupAdapter(binding, note)
    }

}

private fun setupAdapter(binding: FragmentCharacterBinding, listNote: List<Note>) {
    binding.recyclerView.adapter = NoteListAdapter(notes = listNote, onEventClicked = {
        val bundle = bundleOf("note" to it)
        binding.recyclerView.findNavController()
            .navigate(R.id.action_characterFragment_to_selectedCharFragment, bundle)
    })
}

