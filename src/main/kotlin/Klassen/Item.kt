package Klassen
// der heilungswert kann auch bei normalen items verwendet werden. standard ist er auf null gesetzt
open class Item(var name: String, var anzahl: Int,var heilungsWert: Int? = null){





    open fun benutzeItem(item: Item,held:Held) {
        if (item.heilungsWert != null) {
            item.heilungsWert = item.heilungsWert!! + item.heilungsWert!!
            println("$name hat das Item ${item.name} benutzt und um ${item.heilungsWert} geheilt.")
        } else {
            println("$name kann das Item ${item.name} nicht benutzen, da es keinen Heilungswert hat.")
        }
    }
}
