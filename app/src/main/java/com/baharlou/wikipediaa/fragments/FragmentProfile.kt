package com.baharlou.wikipediaa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.baharlou.wikipediaa.databinding.FragmentProfileBinding

class FragmentProfile : Fragment() {
    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbar()
        setCollapsing()
    }


    private fun setCollapsing() {
        binding.collapsingMain.setExpandedTitleColor(
            ContextCompat.getColor(requireContext(), android.R.color.transparent)
        )
        binding.collapsingMain.title = "About Me"
    }

    private fun setToolbar() {
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarMain)

    }
}