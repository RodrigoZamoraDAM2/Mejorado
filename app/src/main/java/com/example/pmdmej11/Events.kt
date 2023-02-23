package com.example.mejorado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mejorado.databinding.EventsBinding
import kotlin.random.Random

class Events : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = EventsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dado.setOnClickListener(){
            val n = Random.nextInt(1,5)
            var heroe = intent?.getSerializableExtra("heroe") as Personaje


            if (n == 1){
                val intent = Intent(this@Events,ObjetoEvent::class.java)
                intent.putExtra("heroe",heroe)
                startActivity(intent)
            }
            else if (n == 2){
                val intent = Intent(this@Events,CiudadEvent::class.java)
                intent.putExtra("heroe",heroe)
                startActivity(intent)
            }
            else if (n == 3){
                val intent = Intent(this@Events,MercaderEvent::class.java)
                intent.putExtra("heroe",heroe)
                startActivity(intent)
            }
            else {
                val intent = Intent(this@Events,EnemigoEvent::class.java)
                intent.putExtra("heroe",heroe)
                startActivity(intent)
            }
        }
        binding.ciupause.setOnClickListener(){
            AudioPlay.stopAudio()
            AudioPlay.disabled = true
        }
        binding.ciuplay.setOnClickListener(){
            AudioPlay.disabled = false
        }

    }
}