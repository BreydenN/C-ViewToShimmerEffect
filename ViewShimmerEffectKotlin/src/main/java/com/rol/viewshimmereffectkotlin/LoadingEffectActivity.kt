package com.rol.viewshimmereffectkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rol.viewshimmereffectkotlin.databinding.ActivityLoadingEffectBinding

class LoadingEffectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoadingEffectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingEffectBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}