package kotlin_avanzado.genericos

fun main() {

    val nombres: MutableList<String> = mutableListOf("Maria", "Pedro", "Santiago")
    val edades: MutableList<Int> = mutableListOf(32, 54, 12)
    val miMapa: Map<String, Int> = nombres.zip(edades).toMap()

    /**
     * Representacion de tipos para clases genéricas
     * E -> Elementos
     * K -> Claves
     * V -> Valores
     * N -> Numeros
     * T, S, V, O -> Tipos
     * */
    val sofa = Sofa("Praga", 3, Dimension(5.2, 1.8, 1.6))
    val caja = Caja(sofa, Dimension(6.0, 2.0, 1.8))
    val caja2 = Caja(Mesa("Brisa", 4, Dimension(2.5, 2.5, 1.7)), Dimension(3.0, 3.0, 2.0))
}