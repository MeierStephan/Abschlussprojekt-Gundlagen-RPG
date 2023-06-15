import Klassen.*

fun main() {

    val charListe: MutableList<Held> = mutableListOf()
    charListe.add(Mage("Medivh", 2500))
    charListe.add(Warrior("Garrosh", 6000))
    charListe.add(Priest("Anduin", 3000))

    var aktuellerSpielerIndex = 0
    var aktuelleRunde = 0
    val boss = Boss("Lichking", 10000)
    val heldenTod = false


    while (boss.HP > 0 && !heldenTod) {
        println("---------- Runde ${aktuelleRunde + 1}: ---------\n")

        val aktuellerSpieler = charListe[aktuellerSpielerIndex]
        aktuellerSpieler.zeigeAngriffe()

        val input = readln()

        when (aktuellerSpieler) {
            is Mage -> {
                when (input) {
                    "1" -> aktuellerSpieler.feuerball(boss)
                    "2" -> aktuellerSpieler.pyroblast(boss)
                    "3" -> aktuellerSpieler.versengen(boss)
                    "4" -> aktuellerSpieler.frostblitz(boss)
                    else -> println("Falsche Eingabe!")
                }
            }

            is Warrior -> {
                when (input) {
                    "1" -> aktuellerSpieler.blutdurst(boss)
                    "2" -> aktuellerSpieler.wuetenderSchlag(boss)
                    "3" -> aktuellerSpieler.hinrichten(boss)
                    "4" -> aktuellerSpieler.zerschmettern(boss)
                    else -> println("Falsche Eingabe")
                }
            }

            is Priest -> {
                when (input) {
                    "1" -> aktuellerSpieler.gedankenschlag(boss)
                    "2" -> aktuellerSpieler.verschlingendeSeuche(boss)
                    "3" -> aktuellerSpieler.heiligerPein(boss)
                    "4" -> aktuellerSpieler.heilung(charListe)
                    else -> println("Falsche Eingabe")
                }
            }
        }

        aktuellerSpielerIndex++
        if (aktuellerSpielerIndex >= charListe.size) {
            aktuellerSpielerIndex = 0
            val bossAngriffIndex = (1..5).random()
            println("----- BOSS Angriff -----")
            when (bossAngriffIndex) {

                1 -> boss.auslöschen(charListe)
                2 -> boss.nahkampf(charListe)
                3 -> boss.froststoß(charListe)
                4 -> boss.schield(boss)
                5 -> boss.heilung(boss)

            }
            println()
            println("Leben der Helden: ")
            for (held in charListe)
                println("${held.name} : ${held.HP}")
        }

        aktuelleRunde++
    }

    println("Das Spiel ist vorbei")
}
