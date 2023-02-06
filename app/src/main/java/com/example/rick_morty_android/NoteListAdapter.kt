package com.example.rick_morty_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_morty_android.activity.MainActivity
import com.example.rick_morty_android.databinding.ListItemBinding
import com.example.rick_morty_android.databinding.ListItemBinding.inflate
import com.example.rick_morty_android.fragment.CharacterFragment
import com.example.rick_morty_android.model.Note

class NoteListAdapter(private val notes: List<Note>, val onEventClicked: (Note) -> Unit) :
    RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        // Essa função infla/monta o layout de item da RecyclerView
        return NoteViewHolder(inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        //Pega o tamanho da lista
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    inner class NoteViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //Seta os valores da lista
        //Adapter responsável por gerenciar a lista inteira. NoteViewHolder responsável por gerenciar item por item
        fun bind(note: Note) {
            //binding.imagePerfil.drawable
            binding.titulo.text = note.titulo
            binding.descricao.text = note.descricao
            binding.container.setOnClickListener {
                onEventClicked.invoke(note)
            }
        }

    }


}


