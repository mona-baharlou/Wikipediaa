package com.baharlou.wikipediaa

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.baharlou.wikipediaa.data.ItemPost
import com.baharlou.wikipediaa.databinding.ActivityDetailBinding
import com.baharlou.wikipediaa.fragments.SEND_DATA_TO_DETAIL_ACTIVITY
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()
        setCollapsing()
        setFab()

        getIntentData()
    }

    private fun getIntentData() {
        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_DETAIL_ACTIVITY)

        if (dataPost != null) {

            showData(dataPost)

        }
    }

    private fun showData(dataPost: ItemPost) {
        binding.title.text = dataPost.title
        binding.detail.text = dataPost.detail

        Glide.with(this)
            .load(dataPost.imgUrl)
            .into(binding.imgDetail)

        binding.fabOpenSite.setOnClickListener {
            //open wikiPedia
            val url = "https://en.wikipedia.org/wiki/Main_Page"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    private fun setFab() {
        binding.fabOpenSite.setOnClickListener {

        }
    }

    private fun setCollapsing() {
        binding.collapsingMain.setExpandedTitleColor(
            ContextCompat.getColor(this, android.R.color.transparent)
        )

        //binding.collapsingMain.title = "my title"
    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbarMain)

        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        return true
    }
}