package com.example.mejorado

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mejorado.databinding.CharacterdetailsBinding
import kotlin.random.Random

class CharacterDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = CharacterdetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val clase = intent.getStringExtra("clase")
        val raza = intent.getStringExtra("raza")

        if (raza == "humano")
            binding.imgraza.setImageResource(R.drawable.humano)
        else if (raza == "elfo")
            binding.imgraza.setImageResource(R.drawable.elfo)
        else if (raza == "enano")
            binding.imgraza.setImageResource(R.drawable.enano)
        else
            binding.imgraza.setImageResource(R.drawable.goblin)

        if (clase == "ladron")
            binding.imgclase.setImageResource(R.drawable.ladron)
        else if(clase == "berserker")
            binding.imgclase.setImageResource(R.drawable.berserker)
        else if(clase == "mago")
            binding.imgclase.setImageResource(R.drawable.mago)
        else if(clase == "guerrero")
            binding.imgclase.setImageResource(R.drawable.guerrero)
        else if(clase == "arquero")
            binding.imgclase.setImageResource(R.drawable.arquero)
        else
            binding.imgclase.setImageResource(R.drawable.mercader)

        var heroe = Personaje(Random.nextInt(10,15),Random.nextInt(1,5),200,100)

        binding.fuerza.text = heroe.fuerza.toString()
        binding.defensa.text = heroe.defensa.toString()
        binding.mochila.text = heroe.pesoMochila.toString()
        binding.vida.text = heroe.vida.toString()
        binding.monedero.text = heroe.monedero.toString()

        binding.volverboton.setOnClickListener(){
            val intent = Intent(this@CharacterDetails,Race::class.java)
            startActivity(intent)
        }

        binding.comenzarboton.setOnClickListener(){
            AudioPlay.stopAudio()
            val intent = Intent(this@CharacterDetails,Events::class.java)
            intent.putExtra("heroe",heroe)
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