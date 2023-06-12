import Klassen.Boss
import Klassen.Mage
import Klassen.Priest
import Klassen.Warrior

fun main(){
    var mage = Mage("Mage",1500)
    var warrior = Warrior("Warrior",3000)
    var prist = Priest("Prist",2000)
    var endboss = Boss("Lichking",10000)

    mage.feuerball(endboss)
    warrior.blutdurst(endboss)
}