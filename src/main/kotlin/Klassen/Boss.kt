package Klassen

open class Boss(var name: String, var HP: Int, val bossMaxHP :Int) {



    fun ausloeschen(charList: List<Held>) {
        val schaden = (200..2000).random()
        val zufaelligerHeld = charList.random()
        zufaelligerHeld.HP -= schaden
        println("$name setzt ${::ausloeschen.name.uppercase()} ein!")
        println("$name hat ${zufaelligerHeld.name} $schaden hinzugefügt")
        println("${zufaelligerHeld.name} hat noch ${zufaelligerHeld.HP}")
    }

    fun nahkampf(charList: List<Held>) {
        val schaden = (150..2000).random()
        val zufaelligerHeld = charList.random()
        zufaelligerHeld.HP -= schaden
        println("$name setzt ${::nahkampf.name.uppercase()} ein!")
        println("$name hat ${zufaelligerHeld.name} $schaden hinzugefügt")
        println("${zufaelligerHeld.name} hat noch ${zufaelligerHeld.HP}")
    }

    fun froststoß(charList: List<Held>) {
        val schaden = (200..2000).random()
        val zufaelligerHeld = charList.random()
        zufaelligerHeld.HP -= schaden
        println("$name setzt ${::froststoß.name.uppercase()} ein!")
        println("$name hat ${zufaelligerHeld.name} $schaden hinzugefügt")
        println("${zufaelligerHeld.name} hat noch ${zufaelligerHeld.HP}")

    }

    fun heilung(boss: Boss) {
        val heal = (150..200).random()
        println("$name setzt ${::heilung.name.uppercase()} ein")
        if (this.HP < this.bossMaxHP) {
            println("Du wurdest um $heal geheilt!")
            boss.HP += heal
        } else {
            println("Dein Leben ist bereits voll.")
        }
    }

    fun schield(boss: Boss) {
        val wert = (300..500).random()
        boss.HP += wert
        println("$name setzt ${::schield.name.uppercase()} ein")
    }

    fun helferBeschwoeren(){

    }
}