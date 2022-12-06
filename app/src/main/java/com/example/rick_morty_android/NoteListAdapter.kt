package com.example.rick_morty_android

import android.app.LauncherActivity
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_morty_android.databinding.ListItemBinding
import com.example.rick_morty_android.databinding.ListItemBinding.inflate

class NoteListAdapter(private val notes: List<Note>) :
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
            binding.titulo.text = note.texto
            binding.descricao.text = note.texto
        }
    }


}