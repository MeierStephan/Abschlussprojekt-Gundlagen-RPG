package Klassen

import ANGRIFF_TIMER
import bossLP

// Mittel Leben und mittel schaden, mit Heilungszauber
open class Priest(name: String, HP: Int) : Held(name, HP) {

    override fun zeigeAngriffe() {
        super.zeigeAngriffe()
        println(
            """
            1. Gedankenschlag
            2. Verschlingende Seuche
            3. Heiliger Pein
            4. Heilung
        """.trimIndent()
        )
    }

    fun gedankenschlag(boss: Boss) {
        var schaden = (200..250).random()
        boss.HP = boss.HP - schaden
        println("${::gedankenschlag.name.uppercase()} wurde eingesetzt. Es macht $schaden Schaden gegen ${boss.name}")
        bossLP(boss, schaden)
    }

    fun verschlingendeSeuche(boss: Boss) {
        var schaden = (250..350).random()
        val heal = schaden / 100 * 10
        HP += heal
        println("${::verschlingendeSeuche.name.uppercase()}wurde eingesetzt. Es macht $schaden Schaden gegen ${boss.name}")
        if (this.HP > 0) {
            println("Dein Leben ist bereits voll.")
        } else {
            println("Du wurdest um $heal geheilt!")
        }
        bossLP(boss, schaden)
    }

    fun heiligerPein(boss: Boss) {
        var schaden = (200..250).random()
        boss.HP = boss.HP - schaden
        println("${::heiligerPein.name.uppercase()} wurde eingesetzt. Es macht $schaden Schaden gegen ${boss.name}")
        bossLP(boss, schaden)
    }

//    fun heilung(held: Held) {
//        var heal = (350..400).random()
//        println("${::heilung.name.uppercase()} wurde eingesetzt.")
//
//    }

    fun heilung(charList:List<Held>) {
        val heal = (200..300).random()
        println("Welchen Helden willst du Heilen?")
        zeigeHelden(charList)
        val input = readln()
        val ausgewaehlterHeal = when (input) {
            "1" -> charList[0]
            "2" -> charList[1]
            "3" -> charList[2]
            else -> null
        }
        if (ausgewaehlterHeal != null) {
            if (ausgewaehlterHeal.HP < 0) {
                println("Heilung in Höhe von $heal ist eingegangen!")
                ausgewaehlterHeal.HP += heal
                println("Heilung auf ${ausgewaehlterHeal.name} einsetzte mit $heal.")
            } else {
                println("${ausgewaehlterHeal.name} hat bereits volles Leben!")
            }
        } else {
            println("Falsche Eingabe")
        }
    }



    }
