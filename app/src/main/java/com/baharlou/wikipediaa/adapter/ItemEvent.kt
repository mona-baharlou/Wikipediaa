package com.baharlou.wikipediaa.adapter

import com.baharlou.wikipediaa.data.ItemPost

interface ItemEvent  {

    fun onItemClicked(itemPost: ItemPost)

}