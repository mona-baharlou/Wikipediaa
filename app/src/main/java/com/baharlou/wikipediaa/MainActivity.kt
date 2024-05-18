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
    }

    private fun toggleDrawer() {
       /* val actionBarDrawerToggle: ActionBarDrawerToggle(
        this,
        binding.drawerLayoutMain,
        binding.toolbarMain,
        R.string.open_drawer,
        R.string.close_drawer,

        )*/
    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbarMain)


    }
}