package com.baharlou.wikipediaa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.baharlou.wikipediaa.data.ItemPost
import com.baharlou.wikipediaa.databinding.ItemExploreBinding
import com.bumptech.glide.Glide

class ExploreAdapter(private val data: ArrayList<ItemPost>) :
    RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {

    lateinit var binding: ItemExploreBinding

    inner class ExploreViewHolder(iteView: View) : RecyclerView.ViewHolder(iteView) {
        fun bindViews(itemPost: ItemPost) {

            Glide.with(itemView.context)
                .load(itemPost.imgUrl)
                .into(binding.imgExploreMain)



            binding.txtExploreTitle.text = itemPost.title
            binding.txtExploreSubtitle.text = itemPost.subtitle
            binding.txtExploreDetail.text = itemPost.detail

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        binding = ItemExploreBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false

        )

        return ExploreViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bindViews(data[position])
    }


}