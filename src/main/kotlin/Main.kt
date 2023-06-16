import Klassen.*

fun main() {
// Anlegen einer leeren Liste wo Helden hinzugefügt werden.
    val charListe: MutableList<Held> = mutableListOf()
    charListe.add(Mage("Medivh", 2500))
    charListe.add(Warrior("Garrosh", 6000))
    charListe.add(Priest("Anduin", 3000))
// Definieren des SpielerIndex der am anfang auf 0 ist
// Definieren der aktuellen Runde die am Anfang auf 0 ist
// Erstellen des Bosses
//
    var aktuellerSpielerIndex = 0
    var aktuelleRunde = 0
    val boss = Boss("Lichking", 10000)
    val heldenTod = false

    val inventar : MutableList<Item> = mutableListOf()
    inventar.add(Item("Heiltrank",20,300))



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
                    "i" ->  {
                        println("Inventar:")
                        for (i in inventar.indices)
                            println("$i ${inventar[i]}")


                    }
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
