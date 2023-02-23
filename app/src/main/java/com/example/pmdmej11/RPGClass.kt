package com.example.mejorado

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mejorado.databinding.RpgclassBinding


class RPGClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = RpgclassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var clase = ""
        var raza = intent.getStringExtra("raza")

        lateinit var mp : MediaPlayer


        binding.ladron.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.ladron)
            clase = "ladron"
            mp = MediaPlayer.create(this, R.raw.electricity)
            mp.start()
        }
        binding.berserker.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.berserker)
            clase = "berserker"
            mp = MediaPlayer.create(this, R.raw.valhala)
            mp.start()
        }
        binding.mago.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.mago)
            clase = "mago"
            mp = MediaPlayer.create(this, R.raw.mago)
            mp.start()
        }
        binding.guerrero.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.guerrero)
            clase = "guerrero"
            mp = MediaPlayer.create(this, R.raw.warrior)
            mp.start()
        }
        binding.arquero.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.arquero)
            clase = "arquero"
            mp = MediaPlayer.create(this, R.raw.archer)
            mp.start()
        }
        binding.mercader.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.mercader)
            clase = "mercader"
            mp = MediaPlayer.create(this, R.raw.money)
            mp.start()
        }
        binding.aceptar.setOnClickListener(){
            val intent = Intent(this@RPGClass, CharacterDetails::class.java)
            intent.putExtra("raza",raza)
            intent.putExtra("clase",clase)
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