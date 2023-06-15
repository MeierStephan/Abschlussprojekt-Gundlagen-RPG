package Klassen

import ANGRIFF_TIMER
import bossLP

open class Warrior(name: String, HP: Int) : Held(name, HP) {

    override fun zeigeAngriffe() {
        super.zeigeAngriffe()
        println(
            """
            1. Blutdurst (DPS + Heal)
            2. Wütender Schlag
            3. Hinrichten (ab 20%)
            4. Zerschmettern
        """.trimIndent()
        )
    }


    fun blutdurst(boss: Boss) {
        val schaden = (200..250).random()
        val heal = schaden / 100 * 10
        println("${::blutdurst.name.uppercase()} wurde eingesetzt. Es macht $schaden Schaden gegen ${boss.name}")
        if (this.HP > 0) {
            println("Dein Leben ist bereits voll.")
        } else {
            println("Du wurdest um $heal geheilt!")
            HP += heal
        }
        bossLP(boss, schaden)
    }

    fun wuetenderSchlag(boss: Boss) {
        val schaden = (250..350).random()
        println("${::wuetenderSchlag.name.uppercase()} Schlag wurde eingesetzt. Es macht $schaden Schaden gegen ${boss.name}")
        bossLP(boss, schaden)
    }

    fun hinrichten(boss: Boss) {
        var schaden = (400..500).random()
        if (boss.HP > boss.HP / 100 * 20) {
            println("${::hinrichten.name.uppercase()} wurde eingesetz. Es macht $schaden Schaden gegen den ${boss.name}")
            bossLP(boss, schaden)
        } else {
            println("Attacke erste einsatz bereit wenn ${boss.name} min. 20% leben hat.")
        }
    }

    fun zerschmettern(boss: Boss) {
        var schaden = (200..300).random()
        ANGRIFF_TIMER()
        println("${::zerschmettern.name.uppercase()} wurde eingesetzt. Es macht $schaden Schaden gegen den ${boss.name}")
        bossLP(boss, schaden)
    }
}