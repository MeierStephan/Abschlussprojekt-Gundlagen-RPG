package Klassen

open class Held(val name: String, var HP: Int) {


    open fun zeigeAngriffe() {
        println("$name, welche Attacke willst du auswählen?\n")

    }


}