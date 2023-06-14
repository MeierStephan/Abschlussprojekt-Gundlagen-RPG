import Klassen.*
import kotlin.math.roundToInt


fun bossLP(boss: Boss, schaden: Int) {
    val bossLebenInProzent = (boss.HP.toDouble() / boss.bossLebenMax) * 100
    boss.HP -= schaden
    println("Der ${boss.name} hat noch ${bossLebenInProzent.roundToInt()}%\n")
}

fun ANGRIFF_TIMER() {
    Thread.sleep(1000)
}








