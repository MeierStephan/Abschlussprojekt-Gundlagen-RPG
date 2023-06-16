import Klassen.*

fun main() {
    val charListe: MutableList<Held> = mutableListOf()
    charListe.add(Mage("Medivh", 2500))
    charListe.add(Warrior("Garrosh", 6000))
    charListe.add(Priest("Anduin", 3000))

    var priester = Priest("test",1000)


//    val inventory = Inventar("Inventar",1)
//    val heiltrank = Item("Heiltrank",10,300)
//    inventory.addItem(heiltrank)
//    println("${heiltrank.name} , ${heiltrank.anzahl}")


    var inventar : MutableList<Item> = mutableListOf()
    inventar.add(Item("Heiltank",10,300))
    val heiltrank = inventar.find { it.name == "Heiltrank" }











    }












