package com.example.rick_morty_android.activity

import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.rick_morty_android.R
import com.example.rick_morty_android.databinding.ActivityMainBinding
import com.example.rick_morty_android.fragment.SelectedCharFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val fragmentManager = supportFragmentManager

    //Variaveis da Dialog de pesquisar personagem
    lateinit var pesquisaDialog: Dialog

    //Variaveis da Dialog de adicionar personagem
    lateinit var addDialog: Dialog

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
        val addBotao = addDialog.findViewById<Button>(R.id.addCharDialogButton)
        val addCancelBotao = addDialog.findViewById<Button>(R.id.addCancelarDialogButton)

        addBotao.setOnClickListener {
            //Adicionar personagem - TODO
            Toast.makeText(this, "Adicionando", Toast.LENGTH_LONG).show()
            addDialog.dismiss()
        }

        addCancelBotao.setOnClickListener { addDialog.dismiss() }
        addDialog.show()

    }

    fun displaySearchDialog() {
        //Mostra o Dialog de pesquisar por personagem
        pesquisaDialog = Dialog(this)
        pesquisaDialog.setContentView(R.layout.search_dialog)
        pesquisaDialog.setCancelable(true)
        //val pesquisaEditText = pesquisaDialog.findViewById<EditText>(R.id.searchDialogEdit)
        val pesquisaBotao = pesquisaDialog.findViewById<Button>(R.id.searchDialogButton)
        val pesquisaCancelBotao = pesquisaDialog.findViewById<Button>(R.id.searchCancelDialogButton)


        pesquisaBotao.setOnClickListener {
            //Pesquisar/filtrar personagens da RecyclerView - TODO
            Toast.makeText(this, "Pesquisando", Toast.LENGTH_LONG).show()
            pesquisaDialog.dismiss()
        }

        pesquisaCancelBotao.setOnClickListener { pesquisaDialog.dismiss() }
        pesquisaDialog.show()

    }

}

