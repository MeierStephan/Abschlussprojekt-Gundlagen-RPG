package Klassen


import bossLP

// Mittel Leben und mittel schaden, mit Heilungszauber
open class Priest(name: String, HP: Int,maxHP:Int) : Held(name, HP,maxHP) {
    val red = "\u001B[31m"
    val green = "\u001B[32m"
    val black = "\u001B[0m"

    override fun zeigeAngriffe() {
        super.zeigeAngriffe()
        println(
            """
            1. Gedankenschlag
            2. Verschlingende Seuche
            3. Heiliger Pein
            4. Heilung
            i. Inventar
        """.trimIndent()
        )
    }

    fun gedankenschlag(boss: Boss) {
        val schaden = (200..250).random()
        boss.HP = boss.HP - schaden
        println("${::gedankenschlag.name.uppercase()} wurde eingesetzt. Es macht ${red}$schaden Schaden ${black} gegen ${boss.name}")
        bossLP(boss, schaden)
    }

    fun verschlingendeSeuche(boss: Boss) {
        val schaden = (250..350).random()
        val heal = schaden / 100 * 10
        println("${::verschlingendeSeuche.name.uppercase()}wurde eingesetzt. Es macht ${red}$schaden Schaden ${black} gegen ${boss.name}")
        if (this.HP < this.maxHP){
            println("Du wurdest um $heal geheilt!")
            HP += heal
        } else {
            println("Dein Leben ist bereits voll.")
        }
        bossLP(boss, schaden)
    }

    fun heiligerPein(boss: Boss) {
        val schaden = (200..250).random()
        boss.HP = boss.HP - schaden
        println("${::heiligerPein.name.uppercase()} wurde eingesetzt. Es macht ${red}$schaden Schaden ${black} gegen ${boss.name}")
        bossLP(boss, schaden)
    }



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
            if (ausgewaehlterHeal.HP < ausgewaehlterHeal.maxHP) {
                println("Heilung in Höhe von $heal ist eingegangen!")
                ausgewaehlterHeal.HP += heal
                println("${ausgewaehlterHeal.name}: ${ausgewaehlterHeal.HP}")
//                println("Heilung auf ${ausgewaehlterHeal.name} einsetzte mit $heal.")
            } else {
                println("${ausgewaehlterHeal.name} hat bereits volles Leben!")
            }
        } else {
            println("Falsche Eingabe")
        }
    }



    }
