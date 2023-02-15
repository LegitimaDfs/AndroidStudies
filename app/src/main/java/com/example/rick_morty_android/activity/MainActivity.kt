package com.example.rick_morty_android.activity

import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_morty_android.NoteListAdapter
import com.example.rick_morty_android.R
import com.example.rick_morty_android.databinding.ActivityMainBinding
import com.example.rick_morty_android.fragment.SelectedCharFragment
import com.example.rick_morty_android.fragment.setupAdapter
import com.example.rick_morty_android.model.Note
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val fragmentManager = supportFragmentManager

    //Variaveis da Dialog de pesquisar personagem
    lateinit var pesquisaDialog: Dialog

    //Variaveis da Dialog de adicionar personagem
    lateinit var addDialog: Dialog

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val mainToolbar: Toolbar = findViewById(R.id.mainToolbar)
        setSupportActionBar(mainToolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        //Function que detecta qual dos itens da toolbar foi selecionado
        R.id.pesquisa -> {
            displaySearchDialog()
            true
        }

        R.id.add -> {
            displayAddDialog()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }


    fun onClickFirst(view: View) {
        //Função de transacionar entre as Fragments
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.recyclerView, SelectedCharFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun displayAddDialog() {
        //Mostra o Dialog de adicionar personagem
        addDialog = Dialog(this)
        addDialog.setContentView(R.layout.add_char_dialog)
        addDialog.setCancelable(true)
        val addNome = addDialog.findViewById<TextInputEditText>(R.id.addDialogName)
        val addDesc = addDialog.findViewById<TextInputEditText>(R.id.addDialogDescription)
        val addBotao = addDialog.findViewById<Button>(R.id.addCharDialogButton)
        val addCancelBotao = addDialog.findViewById<Button>(R.id.addCancelarDialogButton)

        addBotao.setOnClickListener {
            //Adicionar personagem - TODO
            val snackbar: Snackbar

            if (addNome.text.toString().isNotEmpty() && addDesc.text.toString().isNotEmpty()) {
                //Toast.makeText(this, "Adicionando", Toast.LENGTH_LONG).show()
                //Note("", addNome.text.toString(), addDesc.text.toString())
                snackbar =
                    Snackbar.make(binding.root, "Personagem adicionado", Snackbar.LENGTH_LONG)
                snackbar.setAction("Desfazer", View.OnClickListener {
                    Toast.makeText(this, "Personagem removido", Toast.LENGTH_SHORT).show()
                })
                snackbar.show()

            }


            addDialog.dismiss()
        }

        addCancelBotao.setOnClickListener {
            addDialog.dismiss()
        }
        addDialog.show()

    }

    fun displaySearchDialog() {
        //Mostra o Dialog de pesquisar por personagem
        pesquisaDialog = Dialog(this)
        pesquisaDialog.setContentView(R.layout.search_dialog)
        pesquisaDialog.setCancelable(true)
        recyclerView = findViewById(R.id.recyclerView)

        val pesquisaSearchView = pesquisaDialog.findViewById<SearchView>(R.id.searchViewDialog)
        val pesquisaBotao = pesquisaDialog.findViewById<Button>(R.id.searchDialogButton)
        val pesquisaCancelBotao = pesquisaDialog.findViewById<Button>(R.id.searchCancelDialogButton)

        pesquisaSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                TODO("Not yet implemented")
            }


        })


        pesquisaBotao.setOnClickListener {
            //Pesquisar/filtrar personagens da RecyclerView - TODO("Not yet implemented")
            Toast.makeText(this, "Pesquisando", Toast.LENGTH_LONG).show()
            pesquisaDialog.dismiss()
        }

        pesquisaCancelBotao.setOnClickListener { pesquisaDialog.dismiss() }
        pesquisaDialog.show()

    }

}

