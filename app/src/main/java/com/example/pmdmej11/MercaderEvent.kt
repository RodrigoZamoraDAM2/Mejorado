package com.example.mejorado

import AudioPlay
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.example.mejorado.databinding.MercadereventBinding

class MercaderEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MercadereventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var heroe = intent?.getSerializableExtra("heroe") as Personaje

        AudioPlay.playAudio(this,R.raw.mercado)


        binding.comerciar.setOnClickListener(){
            binding.comerciar.visibility = View.INVISIBLE
            binding.mercontinuar.visibility = View.INVISIBLE
            binding.comprar.visibility = View.VISIBLE
            binding.vender.visibility = View.VISIBLE
            binding.cancelar.visibility = View.VISIBLE
            binding.editTextTextPersonName2.visibility = View.INVISIBLE
        }
        binding.comprar.setOnClickListener(){
            binding.imageView6.setImageResource(R.drawable.objeto125)
            binding.editTextTextPersonName2.visibility = View.VISIBLE
            binding.editTextTextPersonName2.hint = "cantidad a comprar"
        }
        binding.vender.setOnClickListener(){
            binding.imageView6.setImageResource(R.drawable.pepa)
            binding.editTextTextPersonName2.visibility = View.VISIBLE
            binding.editTextTextPersonName2.hint = "cantidad a vender"
            if(binding.editTextTextPersonName2.text.toString() != "") {
                var vendidos = binding.editTextTextPersonName2.text.toString().toInt()
                if (heroe.mochila.size >= vendidos)
                    repeat(vendidos) {
                        heroe.monedero += heroe.tasarObjeto(heroe.mochila.size - 1)
                        heroe.sacarDeMochila(heroe.mochila.size - 1)
                    }
                else
                    Toast.makeText(this, "no tienes tantos objetos", Toast.LENGTH_SHORT).show()
            }
        }
        binding.cancelar.setOnClickListener(){
            binding.comerciar.visibility = View.VISIBLE
            binding.mercontinuar.visibility = View.VISIBLE
            binding.comprar.visibility = View.INVISIBLE
            binding.vender.visibility = View.INVISIBLE
            binding.cancelar.visibility = View.INVISIBLE
            binding.editTextTextPersonName2.visibility = View.INVISIBLE
        }
        binding.mercontinuar.setOnClickListener(){
            binding.editTextTextPersonName2.visibility = View.INVISIBLE
            AudioPlay.stopAudio()
            val intent = Intent(this@MercaderEvent,Events::class.java)
            intent.putExtra("heroe",heroe)
            startActivity(intent)
        }
        binding.ciupause.setOnClickListener(){
            AudioPlay.stopAudio()
            AudioPlay.disabled = true
        }
        binding.ciuplay.setOnClickListener(){
            AudioPlay.disabled = false
            AudioPlay.playAudio(this,R.raw.mercado)
        }
    }
}