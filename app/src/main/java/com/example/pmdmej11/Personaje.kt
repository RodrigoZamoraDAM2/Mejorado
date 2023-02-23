package com.example.mejorado

import java.io.Serializable

class Personaje : Serializable {


    var fuerza = 0
    var defensa = 0
    var vida = 0
    var monedero  = 0
    var pesoMochila = 0
    var mochila = ArrayList<Objeto>()

    constructor(fuerza : Int,defensa : Int, vida : Int, pesoMochila : Int){
        this.fuerza = fuerza
        this.defensa = defensa
        this.vida = vida
        this.pesoMochila = pesoMochila
    }

    fun meterEnMochila(obj : Objeto){
        mochila.add(obj)
    }

    fun sacarDeMochila(i : Int){
        mochila.removeAt(i)
    }

    fun calcularPeso() : Int{
        var acum = 0
        for (obj in mochila){
            acum += obj.peso
        }
        return acum
    }
    fun tasarObjeto(i : Int) : Int{
        return mochila[i].valor
    }

}