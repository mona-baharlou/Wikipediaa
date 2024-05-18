package com.baharlou.wikipediaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.baharlou.wikipediaa.databinding.ActivityMainBinding
import com.baharlou.wikipediaa.fragments.FragmentExplore
import com.baharlou.wikipediaa.fragments.FragmentProfile
import com.baharlou.wikipediaa.fragments.FragmentTrend

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()

        toggleDrawer()

        setMenu()

        setBottomNavigation()

        firstRun()
    }

    private fun setBottomNavigation() {
        binding.bottomNavigationMain.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.menu_explore -> {
                    replaceFragment(FragmentExplore())
                }

                R.id.menu_trend -> {
                    replaceFragment(FragmentTrend())
                }

                R.id.menu_profile -> {
                    replaceFragment(FragmentProfile())
                }
            }

            true

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.commit()
    }

    private fun firstRun() {
        replaceFragment(FragmentExplore())
        binding.bottomNavigationMain.selectedItemId = R.id.menu_explore
    }

    private fun setMenu() {
        binding.navigationViewMain.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menu_writer -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
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
        actionBarDrawerToggle.syncState()


    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbarMain)

    }
}