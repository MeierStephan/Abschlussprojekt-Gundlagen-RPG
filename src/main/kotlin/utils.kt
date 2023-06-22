import Klassen.*
import kotlin.math.roundToInt

val red = "\u001B[31m"
val green = "\u001B[32m"
val black = "\u001B[0m"

// Leben des Bosses wird in % angezeigt
// Schaden der Attacken wird von den HP des Bosses abgezogen
fun bossLP(boss: Boss, schaden: Int) {
    var bossLebenInProzent = (boss.HP.toDouble() / boss.bossMaxHP) * 100
    boss.HP -= schaden
    bossLebenInProzent = (boss.HP.toDouble() / boss.bossMaxHP) * 100
    println("Der ${boss.name} hat noch ${bossLebenInProzent.roundToInt()}%\n")
}

var buffMage = false
var buffWarrior = false
var buffPriest = false
fun itemBenutzen(item: Item, held: Held) {
    if (item.heilungsWert != null) {
        if (held.HP < held.maxHP) {
            val heal = item.heilungsWert!!
            println("${green}${held.name} hat das Item ${item.name} benutzt! ${held.name} wird um $heal geheilt!${black}")
            held.HP += heal
            item.anzahl--
            if (item.anzahl == 0)
                inventar.remove(item)

        } else {
            println("${held.name} hat bereits Volles Leben")
        }
    } else if (buffMage == false) {
            if (item.name == "Vitamine") {
                val buff = (held.maxHP * 0.1).toInt()
                println("${green}${held.name} hat Vitamine benutzt. Sein leben wird um 10% erhöht!${black}")
                held.HP += buff
                item.anzahl--
                held.maxHP = held.HP
                buffMage = true
            }

            if (item.anzahl == 0) {
                inventar.remove(item)
            }
        } else if (buffPriest == false){
            if (item.name == "Vitamine") {
                val buff = (held.maxHP * 0.1).toInt()
                println("${green}${held.name} hat Vitamine benutzt. Sein leben wird um 10% erhöht!${black}")
                held.HP += buff
                item.anzahl--
                held.maxHP = held.HP
                buffPriest = true
            }

        } else if (buffWarrior == false) {
        if (item.name == "Vitamine") {
            val buff = (held.maxHP * 0.1).toInt()
            println("${green}${held.name} hat Vitamine benutzt. Sein leben wird um 10% erhöht!${black}")
            held.HP += buff
            item.anzahl--
            held.maxHP = held.HP
            buffWarrior = true
        }
    } else {
        println("Du bist bereits mit Vitaminen gebufft! ")
    }
}


// Inventar wird ausgegeben mit Items , Anzahl , Heilungswert wenn vorhanden
fun inventarZeigen(inventar: List<Item>) {
    println("Welches Item willst du benutzen")
    println("Inventar:")
    for (i in inventar.indices) {
        val item = inventar[i]
        // Wenn der Heilungswert des Items nicht null ist wir dieser in der Konstanten heilungswertText gespeichert
        val heilungswertText = if (item.heilungsWert != null) "Heilung: ${item.heilungsWert} LP"
        else ""
        // Inventar wird ausgegeben mit i = nummer, anzahl = wv. items , heilungswert = Heilung bei Tränken. Wenn keiner vorhanden wird dieser nicht ausgegeben.
        println("$i: ${inventar[i].anzahl}x ${inventar[i].name} $heilungswertText")

    }
}


fun itemAuswahl(inventar: List<Item>, aktuellerSpieler: Held) {
    val itemAuswahl = readln().toIntOrNull()
    if (itemAuswahl != null && itemAuswahl in inventar.indices) { // es wird geprüft ob das item nicht null ist und ob der wert innerhalb des indices liegt des Inventars
        val itemGewaehlt = inventar[itemAuswahl]
        itemBenutzen(itemGewaehlt, aktuellerSpieler)
    } else {
        println("Falsche Eingabe. Der Kampf geht weiter!")
    }
}


// Gibt die HP des Bosses wieder, wenn er 20% hat.
// Wird benötigt für Angriffe der Helden.
fun minBossHP(boss: Boss): Int {
    return boss.bossMaxHP / 100 * 20


}



