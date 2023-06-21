import Klassen.*

fun main() {
    val charListe: MutableList<Held> = mutableListOf()
    charListe.add(Mage("Medivh", 2500,2500))
    charListe.add(Warrior("Garrosh", 6000,6000))
    charListe.add(Priest("Anduin", 3000,3000))


    var aktuelleRunde = 0
    val boss = Boss("Lichking", 10000,1000)


    val inventar: MutableList<Item> = mutableListOf()
    inventar.add(Item("Heiltrank", 20, 300))

    while (boss.HP > 0 && charListe.isNotEmpty()) {
        println("---------- Runde ${aktuelleRunde + 1}: ---------\n")

        // Alle Helden angreifen lassen
        for (heldIndex in charListe.indices) {
            val aktuellerSpieler = charListe[heldIndex]

                aktuellerSpieler.zeigeAngriffe()

                val input = readln()

                if (aktuellerSpieler.HP > 0) {
                    when (aktuellerSpieler) {
                        is Mage -> {
                            when (input) {
                                "1" -> aktuellerSpieler.feuerball(boss)
                                "2" -> aktuellerSpieler.pyroblast(boss)
                                "3" -> aktuellerSpieler.versengen(boss)
                                "4" -> aktuellerSpieler.frostblitz(boss)
                                "i" -> {
                                    println("Inventar:")
                                    for (i in inventar.indices) {
                                        println("$i ${inventar[i]}")
                                    }
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
                                "i" -> {
                                    println("Inventar:")
                                    for (i in inventar.indices) {
                                        println("$i ${inventar[i]}")
                                    }
                                }
                                else -> println("Falsche Eingabe")
                            }
                        }
                        is Priest -> {
                            when (input) {
                                "1" -> aktuellerSpieler.gedankenschlag(boss)
                                "2" -> aktuellerSpieler.verschlingendeSeuche(boss)
                                "3" -> aktuellerSpieler.heiligerPein(boss)
                                "4" -> aktuellerSpieler.heilung(charListe)
                                "i" -> {
                                    println("Inventar:")
                                    for (i in inventar.indices) {
                                        println("$i ${inventar[i]}")
                                    }
                                }
                                else -> println("Falsche Eingabe")
                            }
                        }
                    }
                }
            }
        }

        // Boss greift an
        if (charListe.isNotEmpty()) {
            val lebendeHelden = charListe.filter { it.HP > 0 }

            val bossAngriffIndex = (1..3).random()
            println("----- BOSS Angriff -----")
            when (bossAngriffIndex) {
                1 -> boss.ausloeschen(lebendeHelden)
                2 -> boss.nahkampf(lebendeHelden)
                3 -> boss.froststoß(lebendeHelden)
                4 -> boss.schield(boss)
                5 -> boss.heilung(boss)
            }
            println()
            println("Leben der Helden:")
            for (held in charListe) {
                println("${held.name}: ${held.HP}")
            }
            println()
        }

        aktuelleRunde++
    }

