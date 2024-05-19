package com.baharlou.wikipediaa.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baharlou.wikipediaa.DetailActivity
import com.baharlou.wikipediaa.adapter.ExploreAdapter
import com.baharlou.wikipediaa.adapter.ItemEvent
import com.baharlou.wikipediaa.adapter.TrendAdapter
import com.baharlou.wikipediaa.data.ItemPost
import com.baharlou.wikipediaa.databinding.FragmentProfileBinding
import com.baharlou.wikipediaa.databinding.FragmentTrendBinding

class FragmentTrend : Fragment(), ItemEvent {
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

        adapter = TrendAdapter(Util.trendItems, this)
        binding.recyclerTrend.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerTrend.adapter = adapter

    }

    override fun onItemClicked(itemPost: ItemPost) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(SEND_DATA_TO_DETAIL_ACTIVITY, itemPost)
        startActivity(intent)
    }
}