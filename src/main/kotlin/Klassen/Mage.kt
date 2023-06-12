package Klassen

import kotlin.concurrent.thread
import kotlin.random.Random

// Wenig leben aber mehr schaden
open class Mage(name : String, HP : Int) :Held(name,HP) {

    open fun bossLP(boss:Boss,schaden : Int){
        Thread.sleep(2000)
        boss.HP -= schaden
        println("Der ${boss.name} hat noch ${boss.HP}")
    }

    fun feuerball(boss:Boss){
        var schaden = (100..150).random()
        println("Feuerball wurde eingesetzt. Es macht $schaden Schaden gegen ${boss.name}")
        bossLP(boss,schaden)
    }

    fun pyroblast(boss:Boss){
        var schaden = (100..200).random()
        println("Pyroblast wurde eingesetzt. Es macht $schaden Schaden gegen ${boss.name}")
        bossLP(boss,schaden)

    }

    fun eisblock(){

    }

//    fun versengen(boss:Boss){
//        var schaden = (200..300).random()
//        boss.hp
//    }








}




