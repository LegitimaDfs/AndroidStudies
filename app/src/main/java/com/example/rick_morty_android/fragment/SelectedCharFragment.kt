package com.example.rick_morty_android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rick_morty_android.R
import com.example.rick_morty_android.databinding.FragmentCharacterBinding
import com.example.rick_morty_android.databinding.FragmentSelectedCharBinding

class SelectedCharFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var binding: FragmentSelectedCharBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSelectedCharBinding.inflate(inflater, container, false)
        return binding.root
    }

    val charName = binding.nomePersonagem




}


