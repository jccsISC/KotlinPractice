package kotlin_avanzado.genericos

fun main() {


    val nombres: MutableList<String> = mutableListOf("Maria", "Pedro", "Santiago")
    val edades: MutableList<Int> = mutableListOf(32, 54, 12)
    val miMapa: Map<String, Int> = nombres.zip(edades).toMap()

    /**
     * Representacion de tipos para clases genéricas
     * K -> Claves
     * V -> Valores
     * */

}