package Klassen
import bossLP
import minBossHP


open class Mage(name: String, HP: Int,maxHP:Int) : Held(name, HP,maxHP) {


    override fun zeigeAngriffe() {
        super.zeigeAngriffe()
        println(
            """
            1. Feuerball
            2. Pyroblast
            3. Versengen (ab 20 %)
            4. Frostblitz
            i . Inventar
        """.trimIndent()
        )
    }

    fun feuerball(boss: Boss) {
        var schaden = (200..250).random()
        println("${::feuerball.name.uppercase()} wurde eingesetzt. Es macht ${red}$schaden Schaden ${black} gegen ${boss.name}")
        bossLP(boss, schaden)
    }

    fun pyroblast(boss: Boss) {
        var schaden = (200..300).random()
        println("${::pyroblast.name.uppercase()} wurde eingesetzt. Es macht ${red}$schaden Schaden ${black} gegen ${boss.name}")
        bossLP(boss, schaden)
    }

    fun frostblitz(boss: Boss) {
        var schaden = (250..300).random()
        println("${::frostblitz.name.uppercase()} wurde eingesetzt. Es macht ${red}$schaden Schaden ${black} gegen ${boss.name}")
        bossLP(boss, schaden)
    }

    fun versengen(boss: Boss) {
        var schaden = (400..500).random()
        if (boss.HP < minBossHP(boss)) {
            println("${::versengen.name.uppercase()}wurde eingesetz. Es macht ${red}$schaden Schaden ${black} gegen den ${boss.name}")
            bossLP(boss, schaden)
        } else {
            println("Attacke kann erst eingesetz werden wenn der  ${boss.name} min. 20% leben hat.")
        }
    }
}




