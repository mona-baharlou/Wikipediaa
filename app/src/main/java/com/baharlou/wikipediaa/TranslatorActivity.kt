package com.baharlou.wikipediaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baharlou.wikipediaa.databinding.ActivityTranslatorBinding

class TranslatorActivity : AppCompatActivity() {
    lateinit var binding: ActivityTranslatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTranslatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}