package com.example.mejorado

import AudioPlay
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mejorado.databinding.LucharBinding
import kotlin.random.Random

class Luchar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LucharBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AudioPlay.playAudio(this,R.raw.mk)
        lateinit var  mp2 : MediaPlayer

        var heroe = intent.getSerializableExtra("heroe") as Personaje
        var vidaEnemigo = 0
        var fuerza = 0
        var artilugio = Objeto(5,10,20)

        if (Random.nextInt(1, 11) > 8){
            vidaEnemigo = 200
            fuerza = 30
        }
        else {
            vidaEnemigo = 100
            fuerza = 20
        }
        binding.enemybar.max = vidaEnemigo
        binding.enemybar.min = 0
        binding.enemybar.progress = 0

        binding.playerbar.max = heroe.vida
        binding.playerbar.min = 0
        binding.playerbar.progress = 0

        println("Fuerza"+heroe.fuerza)
        println("Defensa"+heroe.defensa)
        println("Vida"+heroe.vida)


        binding.atacar.setOnClickListener(){

            mp2 = MediaPlayer.create(this,R.raw.slap)
            mp2.isLooping = false
            mp2.setVolume(100f,100f)
            mp2.start()

            if (Random.nextInt(1,7)>3){
                binding.enemybar.progress += heroe.fuerza
                vidaEnemigo -= heroe.fuerza
            }
            var ataque = fuerza/heroe.defensa
            binding.playerbar.progress += ataque
            heroe.vida -= ataque

            if(vidaEnemigo <= 0){

                heroe.vida = 200
                heroe.meterEnMochila(artilugio)
                heroe.monedero += 100

                AudioPlay.stopAudio()
                mp2.stop()
                mp2 = MediaPlayer.create(this,R.raw.ff)
                mp2.isLooping = false
                mp2.setVolume(100f,100f)
                mp2.start()

                val intent = Intent(this@Luchar,Events::class.java)
                intent.putExtra("heroe",heroe)
                startActivity(intent)
            }
            if(heroe.vida <= 0){
                AudioPlay.stopAudio()
                mp2.stop()
                mp2 = MediaPlayer.create(this,R.raw.death)
                mp2.isLooping = false
                mp2.setVolume(100f,100f)
                mp2.start()
                startActivity(Intent(this@Luchar,Blank::class.java))

            }
        }
        binding.huir.setOnClickListener(){



            if(Random.nextInt(1,7)>4){
                AudioPlay.stopAudio()
                mp2 = MediaPlayer.create(this,R.raw.runaway)
                mp2.isLooping = false
                mp2.setVolume(100f,100f)
                mp2.start()
                heroe.vida = 200
                val intent = Intent(this@Luchar,Events::class.java)
                intent.putExtra("heroe",heroe)
                startActivity(intent)
            }
            else{
                binding.playerbar.progress += fuerza/heroe.defensa

                if(heroe.vida <= 0){
                    AudioPlay.stopAudio()
                    mp2.stop()
                    mp2 = MediaPlayer.create(this,R.raw.grito)
                    mp2.isLooping = false
                    mp2.setVolume(100f,100f)
                    mp2.start()
                    startActivity(Intent(this@Luchar,Blank::class.java))

                }
            }
        }
        binding.objeto.setOnClickListener(){
            if (heroe.mochila.size>0){
                heroe.sacarDeMochila(heroe.mochila.size)
                binding.playerbar.progress -= 20
                heroe.vida += 20
            }
        }
        binding.ciupause.setOnClickListener(){
            AudioPlay.stopAudio()
            AudioPlay.disabled = true
        }
        binding.ciuplay.setOnClickListener(){
            AudioPlay.disabled = false
            AudioPlay.playAudio(this,R.raw.mk)
        }
    }
}