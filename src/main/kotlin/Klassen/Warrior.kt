package Klassen

// mehr leben aber wenigers schaden
open class Warrior(name: String, HP: Int) : Held(name, HP) {


    open fun bossLP(boss: Boss, schaden: Int) {
        Thread.sleep(2000)
        boss.HP -= schaden
        println("Der ${boss.name} hat noch ${boss.HP}")
    }

    fun blutdurst(boss: Boss) {
        var schaden = (100..150).random()
        val heal = schaden / 100 * 10
        HP += heal
        println("Blutdurst wurde eingesetzt. Es macht $schaden Schaden gegen ${boss.name}")
        bossLP(boss, schaden)
        println("Du wurdest um $heal geheilt!")
    }

    fun wuetenderSchlag(boss: Boss) {
        var schaden = (150..200).random()
        boss.HP = boss.HP - schaden
        println("Wütender Schlag wurde eingesetzt. Es macht $schaden Schaden gegen ${boss.name}")
        println("Der ${boss.name} hat noch ${boss.HP}")
    }


}