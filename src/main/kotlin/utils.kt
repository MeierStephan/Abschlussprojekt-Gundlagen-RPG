import Klassen.*
import kotlin.math.roundToInt

// Leben des Bosses wird in % angezeigt
// Schaden der Attacken wird von den HP des Bosses abgezogen
fun bossLP(boss: Boss, schaden: Int) {
    var bossLebenInProzent = (boss.HP.toDouble() / boss.bossMaxHP) * 100
    boss.HP -= schaden
    bossLebenInProzent = (boss.HP.toDouble() / boss.bossMaxHP) * 100
    println("Der ${boss.name} hat noch ${bossLebenInProzent.roundToInt()}%\n")
}

// wenn der heilwert nicht null ist und die helden HP nicht kleiner als 0 sind
fun itemBenutzen(item: Item, held: Held) {
    if (item.heilungsWert != null) {
        if (held.HP < held.maxHP) {
            val heal = item.heilungsWert!!
            println("${held.name} hat das Item ${item.name} benutzt! ${held.name} wird um $heal geheilt!")
            held.HP += heal
            item.anzahl--
        } else {
            println("${held.name} hat bereits Volles Leben")
        }
    } else {
        println("Falsche Eingabe")
    }
}

fun inventarZeigen(inventar: List<Item>) {
    println("Welches Item willst du benutzen")
    println("Inventar:")
    for (i in inventar.indices) {
        println("$i: ${inventar[i].anzahl}x ${inventar[i].name} Heilung: ${inventar[i].heilungsWert} LP")
    }
}

fun itemAuswahl(inventar: List<Item>, aktuellerSpieler: Held) {
    val itemAuswahl = readln().toIntOrNull()
    if (itemAuswahl != null && itemAuswahl in inventar.indices) {
        val itemGewaehlt = inventar[itemAuswahl]
        itemBenutzen(itemGewaehlt, aktuellerSpieler)
    }
}

fun minBossHP(boss:Boss):Int{
    return boss.bossMaxHP / 100 *20

}



