package com.baharlou.wikipediaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import com.baharlou.wikipediaa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()

        toggleDrawer()

        setMenu()
    }

    private fun setMenu() {
        binding.navigationViewMain.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menu_writer -> {

                }

                R.id.menu_photographer -> {

                }

                R.id.menu_video_maker -> {

                }

                R.id.menu_translator -> {

                }

                ///----------------------------------------------/

                R.id.menu_open_wikimedia -> {

                }

                R.id.menu_open_wikipedia -> {

                }
            }

            true
        }

    }

    private fun toggleDrawer() {
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutMain,
            binding.toolbarMain,
            R.string.open_drawer,
            R.string.close_drawer
        )

        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)


    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbarMain)


    }
}