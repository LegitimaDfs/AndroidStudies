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

    lateinit var pesquisaDialog: Dialog
    var pesquisaEditText = findViewById<EditText>(R.id.searchDialogEdit)
    val pesquisaBotao = findViewById<Button>(R.id.searchDialogButton)

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
        R.id.pesquisa -> {
            Toast.makeText(this, "TODO", Toast.LENGTH_LONG).show()
            true
        }

        R.id.add -> {

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




    /*fun displayDialog() {
        pesquisaDialog = Dialog(this)
        pesquisaDialog.setContentView(R.layout.search_dialog)
        pesquisaDialog.setCancelable(true)


        pesquisaBotao.setOnClickListener {

        }

        pesquisaDialog.show()
    }

    fun dataSearchKeep(){
        var editText = pesquisaEditText.text.toString()
        val characterName = findViewById<TextView>(R.id.nomePersonagem).toString()
        if (editText == characterName) {
            findViewById<ConstraintLayout>(R.id.cardSelChar)
        }
    }*/

}

