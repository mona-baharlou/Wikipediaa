package com.baharlou.wikipediaa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baharlou.wikipediaa.adapter.ExploreAdapter
import com.baharlou.wikipediaa.data.ItemPost
import com.baharlou.wikipediaa.databinding.FragmentExploreBinding
import com.baharlou.wikipediaa.databinding.FragmentProfileBinding

class FragmentExplore : Fragment() {
    lateinit var binding: FragmentExploreBinding
    lateinit var adapter: ExploreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExploreBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ExploreAdapter(Util.exploreItems)

        binding.recyclerExplore.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerExplore.adapter = adapter
    }
}