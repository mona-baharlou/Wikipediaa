package com.baharlou.wikipediaa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baharlou.wikipediaa.data.ItemPost
import com.baharlou.wikipediaa.databinding.ItemTrendBinding
import com.bumptech.glide.Glide
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TrendAdapter(private val data: ArrayList<ItemPost>) :
    RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {

    lateinit var binding: ItemTrendBinding

    inner class TrendViewHolder(iteView: View) : RecyclerView.ViewHolder(iteView) {
        fun bindViews(itemPost: ItemPost) {

            Glide.with(itemView.context)
                .load(itemPost.imgUrl)
                .transform(RoundedCornersTransformation(32, 8))
                .into(binding.itemTrendImg)

            binding.itemTrendSubject.text = itemPost.title
            binding.itemTrendCount.text = (adapterPosition + 1).toString()
            binding.itemTrendSubtitle.text = itemPost.subtitle
            binding.itemTrendInsight.text = itemPost.insight

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        binding = ItemTrendBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false

        )

        return TrendViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        holder.bindViews(data[position])
    }


}