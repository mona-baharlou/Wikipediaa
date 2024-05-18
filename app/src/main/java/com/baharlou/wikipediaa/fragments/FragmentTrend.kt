package com.baharlou.wikipediaa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baharlou.wikipediaa.adapter.ExploreAdapter
import com.baharlou.wikipediaa.adapter.TrendAdapter
import com.baharlou.wikipediaa.databinding.FragmentProfileBinding
import com.baharlou.wikipediaa.databinding.FragmentTrendBinding

class FragmentTrend : Fragment() {
    lateinit var binding: FragmentTrendBinding
    lateinit var adapter: TrendAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrendBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TrendAdapter(Util.trendItems)
        binding.recyclerTrend.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerTrend.adapter = adapter

    }
}