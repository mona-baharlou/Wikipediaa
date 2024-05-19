package com.baharlou.wikipediaa.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baharlou.wikipediaa.activities.DetailActivity
import com.baharlou.wikipediaa.adapter.ExploreAdapter
import com.baharlou.wikipediaa.adapter.ItemEvent
import com.baharlou.wikipediaa.data.ItemPost
import com.baharlou.wikipediaa.databinding.FragmentExploreBinding

const val SEND_DATA_TO_DETAIL_ACTIVITY = "sendData"
class FragmentExplore : Fragment(), ItemEvent {
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

        adapter = ExploreAdapter(Util.exploreItems, this)

        binding.recyclerExplore.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerExplore.adapter = adapter
    }

    override fun onItemClicked(itemPost: ItemPost) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(SEND_DATA_TO_DETAIL_ACTIVITY, itemPost)
        startActivity(intent)
    }
}