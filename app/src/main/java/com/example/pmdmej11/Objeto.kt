package com.example.mejorado

import java.io.Serializable

class Objeto : Serializable {

    var peso = 0
    var valor = 0
    var vida = 0

    constructor(peso : Int,valor : Int,vida : Int){
        this.peso = peso
        this.valor = valor
        this.vida = vida
    }
}