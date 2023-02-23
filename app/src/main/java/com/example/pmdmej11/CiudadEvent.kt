package com.example.mejorado

import AudioPlay
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mejorado.databinding.CiudadeventBinding

class CiudadEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = CiudadeventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var heroe = intent?.getSerializableExtra("heroe") as Personaje

        AudioPlay.playAudio(this,R.raw.songofstorms)


        binding.entrar.setOnClickListener(){
            AudioPlay.stopAudio()
            startActivity(Intent(this@CiudadEvent,Blank::class.java))
        }
        binding.ciucontinuar.setOnClickListener(){
            AudioPlay.stopAudio()
            val intent = Intent(this@CiudadEvent,Events::class.java)
            intent.putExtra("heroe",heroe)
            startActivity(intent)
        }
        binding.ciupause.setOnClickListener(){
            AudioPlay.stopAudio()
            AudioPlay.disabled = true
        }
        binding.ciuplay.setOnClickListener(){
            AudioPlay.disabled = false
            AudioPlay.playAudio(this,R.raw.songofstorms)
        }
    }
}