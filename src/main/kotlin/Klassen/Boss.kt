package Klassen

open class Boss(var name: String, var HP: Int) {


    val bossLebenMax = 10000
    fun auslöschen(charList: List<Held>) {
        val schaden = (200..300).random()
        val zufälligerHeld = charList.random()
        zufälligerHeld.HP -= schaden
        println("$name setzt ${::auslöschen.name.uppercase()} ein!")
        println("$name hat ${zufälligerHeld.name} $schaden hinzugefügt")
        println("${zufälligerHeld.name} hat noch ${zufälligerHeld.HP}")
    }

    fun nahkampf(charList: List<Held>) {
        val schaden = (150..200).random()
        val zufälligerHeld = charList.random()
        zufälligerHeld.HP -= schaden
        println("$name setzt ${::nahkampf.name.uppercase()} ein!")
        println("$name hat ${zufälligerHeld.name} $schaden hinzugefügt")
        println("${zufälligerHeld.name} hat noch ${zufälligerHeld.HP}")
    }

    fun froststoß(charList: List<Held>) {
        val schaden = (200..300).random()
        val zufälligerHeld = charList.random()
        zufälligerHeld.HP -= schaden
        println("$name setzt ${::froststoß.name.uppercase()} ein!")
        println("$name hat ${zufälligerHeld.name} $schaden hinzugefügt")
        println("${zufälligerHeld.name} hat noch ${zufälligerHeld.HP}")

    }

    fun heilung(boss: Boss) {
        val heal = (150..200).random()
        println("$name setzt ${::heilung.name.uppercase()} ein")
        if (this.HP > 0) {
            println("Dein Leben ist bereits voll.")
        } else {
            println("Du wurdest um $heal geheilt!")
            boss.HP += heal
        }
    }

    fun schield(boss: Boss) {
        val wert = (300..500).random()
        boss.HP += wert
        println("$name setzt ${::schield.name.uppercase()} ein")
    }

}