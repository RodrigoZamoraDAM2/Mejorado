package com.example.mejorado

import AudioPlay
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mejorado.databinding.RaceBinding


class Race : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = RaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var raza = ""
        if(!AudioPlay.isplayingAudio) {
            AudioPlay.playAudio(this, R.raw.mm3)
        }
        lateinit var mp : MediaPlayer


        binding.humano.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.humano)
            raza = "humano"
            mp = MediaPlayer.create(this, R.raw.grito)
            mp.start()
        }
        binding.elfo.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.elfo)
            raza = "elfo"
            mp = MediaPlayer.create(this, R.raw.elf)
            mp.start()
        }
        binding.enano.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.enano)
            raza = "enano"
            mp = MediaPlayer.create(this, R.raw.gimli)
            mp.start()
        }
        binding.goblin.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.goblin)
            raza = "goblin"
            mp = MediaPlayer.create(this, R.raw.risitas)
            mp.start()
        }
        binding.aceptar.setOnClickListener(){
            val intent = Intent(this@Race, RPGClass::class.java)
            intent.putExtra("raza",raza)
            startActivity(intent)
        }
        binding.ciupause.setOnClickListener(){
            AudioPlay.stopAudio()
            AudioPlay.disabled = true
        }
        binding.ciuplay.setOnClickListener(){
            AudioPlay.disabled = false
            AudioPlay.playAudio(this,R.raw.mm3)
        }
    }
}