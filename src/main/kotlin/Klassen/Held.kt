package Klassen

open class Held(val name: String, var HP: Int, var maxHP: Int) {


    open fun zeigeAngriffe() {
        println("$name, welche Attacke willst du auswählen?\n")

    }


    fun zeigeHelden(charList: List<Held>) {
        for (i in 1..charList.size)
            println("$i : ${charList[i - 1].name}")

    }

}