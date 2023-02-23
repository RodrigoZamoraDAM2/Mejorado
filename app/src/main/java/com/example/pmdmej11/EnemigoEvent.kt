package com.example.mejorado

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mejorado.databinding.EnemigoeventBinding

class EnemigoEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = EnemigoeventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var heroe = intent?.getSerializableExtra("heroe") as Personaje
        var mp : MediaPlayer? = MediaPlayer.create(this,R.raw.seeyou)
        mp!!.start()

        binding.luchar.setOnClickListener(){
            mp.stop()
            val intent = Intent(this@EnemigoEvent,Luchar::class.java)
            intent.putExtra("heroe",heroe)
            startActivity(intent)
        }
        binding.huir.setOnClickListener(){
            mp.stop()
            val intent = Intent(this@EnemigoEvent,Events::class.java)
            intent.putExtra("heroe",heroe)
            startActivity(intent)
        }
    }
}