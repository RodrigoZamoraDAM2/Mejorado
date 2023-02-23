package com.example.mejorado

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mejorado.databinding.ObjetoeventBinding

class ObjetoEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ObjetoeventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var heroe = intent?.getSerializableExtra("heroe") as Personaje
        var artilugio = Objeto(5,10,20)

        var mp : MediaPlayer = MediaPlayer.create(this,R.raw.objeto)
        mp.start()


        binding.recoger.setOnClickListener(){
            mp.stop()
            val intent = Intent(this@ObjetoEvent,Events::class.java)
            if(heroe.calcularPeso()+artilugio.peso <= heroe.pesoMochila)
                heroe.meterEnMochila(artilugio)
            println("tenemos "+heroe.mochila.size+" objetos en la mochila")
            intent.putExtra("heroe",heroe)
            startActivity(intent)
        }
        binding.objcontinuar.setOnClickListener(){
            mp.stop()
            val intent = Intent(this@ObjetoEvent,Events::class.java)
            intent.putExtra("heroe",heroe)
            startActivity(intent)
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