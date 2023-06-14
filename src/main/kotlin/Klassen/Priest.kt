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

    fun heilung(held: Held) {
        var heal = (350..400).random()
        println("${::heilung.name.uppercase()} wurde eingesetzt.")
        if (held.HP < 0) {
            println("Heilung in Höhe von $heal ist eingegangen!")
            held.HP = held.HP + heal
        } else {
            println("${held.name} hat bereits volles Leben!")
        }
    }


}