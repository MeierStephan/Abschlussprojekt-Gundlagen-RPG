package Klassen

open class Inventar(name:String,anzahl:Int):Item(name,anzahl){

    val inventar:MutableList<Item> = mutableListOf()

    fun addItem(item:Item){
        inventar.add(item)
    }

    fun removeItem(item:Item){
        inventar.remove(item)
    }

//    fun inventarAnzeigen() {
//        println("Inventar")
//    }











}