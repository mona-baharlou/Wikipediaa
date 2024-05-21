package com.baharlou.wikipediaa.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.baharlou.wikipediaa.R
import com.baharlou.wikipediaa.TranslatorActivity
import com.baharlou.wikipediaa.databinding.ActivityMainBinding
import com.baharlou.wikipediaa.fragments.FragmentExplore
import com.baharlou.wikipediaa.fragments.FragmentPhotographer
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
        binding.bottomNavigationMain.setOnItemReselectedListener {}
    }

    private fun setMenu() {
        binding.navigationViewMain.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menu_writer -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    val dialog = SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    dialog.titleText = "Alert! "
                    dialog.confirmText = "Confirm"
                    dialog.cancelText = "Cancel"
                    dialog.contentText = "Wanna be a writer?"
                    dialog.setOnCancelListener { dialog.dismiss() }
                    dialog.setConfirmClickListener {
                        dialog.dismiss()
                        Toast.makeText(this, "You can be a writer just work !", Toast.LENGTH_SHORT)
                            .show()
                    }

                    dialog.show()
                }


                R.id.menu_photographer -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    val trasactionP = supportFragmentManager.beginTransaction()
                    trasactionP.add(R.id.frame_main_container, FragmentPhotographer())
                    trasactionP.addToBackStack(null)
                    trasactionP.commit()

                }

                R.id.menu_video_maker -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)


                }

                R.id.menu_translator -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    val intent = Intent(this, TranslatorActivity::class.java)
                    startActivity(intent)

                }

                ///----------------------------------------------/

                R.id.menu_open_wikimedia -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    openWebsite("https://en.wikipedia.org/wiki/Main_Page")
                }

                R.id.menu_open_wikipedia -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    openWebsite("https://www.wikimedia.org/")
                }
            }

            true
        }

    }

    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
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