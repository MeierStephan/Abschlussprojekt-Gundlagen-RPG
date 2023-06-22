package Klassen

import bossLP
import minBossHP


open class Warrior(name: String, HP: Int, maxHP:Int ) : Held(name, HP, maxHP) {
    val red = "\u001B[31m"
    val green = "\u001B[32m"
    val black = "\u001B[0m"


    override fun zeigeAngriffe() {
        super.zeigeAngriffe()
        println(
            """
            1. Blutdurst (DPS + Heal)
            2. Wütender Schlag
            3. Hinrichten (ab 20%)
            4. Zerschmettern
            i. Inventar 
        """.trimIndent()
        )
    }
    fun blutdurst(boss: Boss) {
        val schaden = (200..250).random()
        val heal = schaden / 100 * 10
        println("${::blutdurst.name.uppercase()} wurde eingesetzt. Es macht ${red}$schaden Schaden ${black} gegen ${boss.name}")
        if (this.HP < this.maxHP) {
            println("Du wurdest um $heal geheilt!")
            HP += heal
        } else {
            println("Dein Leben ist bereits voll.")
            bossLP(boss, schaden)
        }
    }

    fun wuetenderSchlag(boss: Boss) {
        val schaden = (250..350).random()
        println("${::wuetenderSchlag.name.uppercase()} Schlag wurde eingesetzt. Es macht ${red}$schaden Schaden ${black} gegen ${boss.name}")
        bossLP(boss, schaden)
    }

    fun hinrichten(boss: Boss) {
        var schaden = (400..500).random()
        if (boss.HP < minBossHP(boss)) {
            println("${::hinrichten.name.uppercase()} wurde eingesetz. Es macht ${red}$schaden Schaden ${black} gegen den ${boss.name}")
            bossLP(boss, schaden)
        } else {
            println("Attacke erste einsatz bereit wenn ${boss.name} min. 20% leben hat.")
        }
    }

    fun zerschmettern(boss: Boss) {
        var schaden = (200..300).random()
        println("${::zerschmettern.name.uppercase()} wurde eingesetzt. Es macht ${red}$schaden Schaden ${black} gegen den ${boss.name}")
        bossLP(boss, schaden)
    }
}