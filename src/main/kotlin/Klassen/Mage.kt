package Klassen

import ANGRIFF_TIMER
import bossLP

// Wenig leben aber mehr schaden
open class Mage(name: String, HP: Int) : Held(name, HP) {


    override fun zeigeAngriffe() {
        super.zeigeAngriffe()
        println(
            """
            1. Feuerball
            2. Pyroblast
            3. Versengen (ab 20 %)
            4. Frostblitz
        """.trimIndent()
        )
    }

    fun feuerball(boss: Boss) {1

        var schaden = (200..250).random()
        println("${::feuerball.name.uppercase()} wurde eingesetzt. Es macht $schaden Schaden gegen ${boss.name}")
        bossLP(boss, schaden)
    }

    fun pyroblast(boss: Boss) {
        var schaden = (200..300).random()
        println("${::pyroblast.name.uppercase()} wurde eingesetzt. Es macht $schaden Schaden gegen ${boss.name}")
        bossLP(boss, schaden)
    }

    fun frostblitz(boss: Boss) {
        var schaden = (250..300).random()
        println("${::frostblitz.name.uppercase()} wurde eingesetzt. Es macht $schaden Schaden gegen ${boss.name}")
        bossLP(boss, schaden)
    }

    fun versengen(boss: Boss) {
        var schaden = (400..500).random()
        if (boss.HP > boss.HP / 100 * 20) {
            println("${::versengen.name.uppercase()}wurde eingesetz. Es macht $schaden Schaden gegen den ${boss.name}")
            bossLP(boss, schaden)
        } else {
            println("Attacke kann erst eingesetz werden wenn der  ${boss.name} min. 20% leben hat.")
        }
    }


}




