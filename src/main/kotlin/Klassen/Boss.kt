package Klassen

open class Boss(var name: String, var HP: Int, val bossMaxHP :Int) {

    val red = "\u001B[31m"
    val green = "\u001B[32m"
    val black = "\u001B[0m"

    fun ausloeschen(charList: List<Held>) {
        val schaden = (200..700).random()
        val zufaelligerHeld = charList.random()
        zufaelligerHeld.HP -= schaden
        println("$name setzt ${::ausloeschen.name.uppercase()} ein!")
        println("$name hat ${zufaelligerHeld.name} ${red}$schaden schaden hinzugefügt!${black}")
        println("${zufaelligerHeld.name} hat noch ${zufaelligerHeld.HP}")
    }

    fun nahkampf(charList: List<Held>) {
        val schaden = (150..500).random()
        val zufaelligerHeld = charList.random()
        zufaelligerHeld.HP -= schaden
        println("$name setzt ${::nahkampf.name.uppercase()} ein!")
        println("$name hat ${zufaelligerHeld.name} $schaden schaden hinzugefügt")
        println("${zufaelligerHeld.name} hat noch ${zufaelligerHeld.HP}")
    }

    fun froststoß(charList: List<Held>) {
        val schaden = (200..700).random()
        val zufaelligerHeld = charList.random()
        zufaelligerHeld.HP -= schaden
        println("$name setzt ${::froststoß.name.uppercase()} ein!")
        println("$name hat ${zufaelligerHeld.name} $schaden schaden hinzugefügt")
        println("${zufaelligerHeld.name} hat noch ${zufaelligerHeld.HP}")

    }

    fun heilung(boss: Boss) {
        val heal = (150..400).random()
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

    fun heulendeBoee(charList: List<Held>){
        val schaden = (200..400).random()
        for(held in charList){
            held.HP -= schaden
            println("${held.name} bekommt ${red}$schaden schaden${black}")
    }



}
}