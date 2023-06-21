import Klassen.*

fun main() {
    // Leere liste für die Helden erstellt
    val charListe: MutableList<Held> = mutableListOf()

    // Hinzufügen von Helden in der Liste
    charListe.add(Mage("Medivh", 2500,2500))
    charListe.add(Warrior("Garrosh", 6000,6000))
    charListe.add(Priest("Anduin", 3000,3000))

    // Leere liste für das Inventar erstellt
    val inventar: MutableList<Item> = mutableListOf()
    // Heiltrank dem Inventar hinzugefügt
    inventar.add(Item("Heiltrank", 20, 300))
    inventar.add(Item("Vitamine",5))

    // Boss erstellt
    val boss = Boss("Lichking", 10000,10000)

    // runden Zähler erstellt
    var aktuelleRunde = 0
    // wenn die Boss HP > 0 und die Liste der Helden nicht leer ist, wird die Schleife ausgeführt
    while (boss.HP > 0 && charListe.isNotEmpty()) {
        println("---------- Runde ${aktuelleRunde + 1}: ---------\n")

        // für jeden held in der charliste
        for (held in charListe.size -1 downTo 0) {
            val aktuellerSpieler = charListe[held]

            if (aktuellerSpieler.HP <= 0) {
                charListe.removeAt(held)
                println("${aktuellerSpieler.name} ist gestorben")
                continue
            }

            // Anzeigen der Skills des aktuellen Helden
            aktuellerSpieler.zeigeAngriffe()

            val skillAuswahl = readln().lowercase()
            // Wenn die leben des aktuellen Helden > 0 ist
            if (aktuellerSpieler.HP > 0) {
                // Wenn der aktuelle Held ein Mage ist, soll der Input folgenden Skill auswählen
                when (aktuellerSpieler) {
                    is Mage -> {
                        when (skillAuswahl) {
                            "1" -> aktuellerSpieler.feuerball(boss)
                            "2" -> aktuellerSpieler.pyroblast(boss)
                            "3" -> aktuellerSpieler.versengen(boss)
                            "4" -> aktuellerSpieler.frostblitz(boss)
                            "i" -> {
                                inventarZeigen(inventar)
                                itemAuswahl(inventar,aktuellerSpieler)
                            }
                            else -> println("Falsche Eingabe!")
                        }
                    }

                    is Warrior -> {
                        when (skillAuswahl) {
                            "1" -> aktuellerSpieler.blutdurst(boss)
                            "2" -> aktuellerSpieler.wuetenderSchlag(boss)
                            "3" -> aktuellerSpieler.hinrichten(boss)
                            "4" -> aktuellerSpieler.zerschmettern(boss)
                            "i" -> {
                                inventarZeigen(inventar)
                                itemAuswahl(inventar,aktuellerSpieler)
                            }
                            else -> println("Falsche Eingabe!")
                        }
                    }

                    is Priest -> {
                        when (skillAuswahl) {
                            "1" -> aktuellerSpieler.gedankenschlag(boss)
                            "2" -> aktuellerSpieler.verschlingendeSeuche(boss)
                            "3" -> aktuellerSpieler.heiligerPein(boss)
                            "4" -> aktuellerSpieler.heilung(charListe)
                            "i" -> {
                                inventarZeigen(inventar)
                                itemAuswahl(inventar,aktuellerSpieler)
                            }
                            else -> println("Falsche Eingabe!")
                        }
                    }
                }
            }
            if (boss.HP <=0){
                break
            }

        }
        // Boss Kampf
        if (charListe.isNotEmpty()) {
            // Liste der Helden wird gefiltert nach Helden die noch am Leben sind
            val heldenAmLeben = charListe.filter { it.HP > 0 }

            // Random Angriff vom boss wird gemacht
            val bossAngriffIndex = (1..5).random()
            println("----- BOSS Angriff -----")
            when (bossAngriffIndex) {
                1 -> boss.ausloeschen(heldenAmLeben)
                2 -> boss.nahkampf(heldenAmLeben)
                3 -> boss.froststoß(heldenAmLeben)
                4 -> boss.schield(boss)
                5 -> boss.heilung(boss)
            }
            // Leben aller Helden wird ausgedruckt
            println()
            println("Leben der Helden: ")
            for (held in charListe) {
                println("${held.name}: ${held.HP}")
            }
            println()
        }
        // Runden Counter wird um 1 erhöht
        aktuelleRunde++
    }
    if (boss.HP <= 0){
        println("Deine Helden haben gesiegt. Der Boss ist gefallen!")
    } else {
        println("Deine Helden sind Tod. Der Boss hat gewonnen!")
    }
}

