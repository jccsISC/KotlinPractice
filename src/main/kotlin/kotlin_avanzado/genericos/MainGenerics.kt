package kotlin_avanzado.genericos

fun main() {

    val nombres: MutableList<String> = mutableListOf("Maria", "Pedro", "Santiago")
    val edades: MutableList<Int> = mutableListOf(32, 54, 12)
    val miMapa: Map<String, Int> = nombres.zip(edades).toMap()

    /**
     * Representacion de parametros de tipos para clases genéricas
     * E -> Elementos
     * K -> Claves
     * V -> Valores
     * N -> Numeros
     * T, S, V, O -> Tipos
     * */
    val sofa = Sofa("Praga", 3, Dimension(5.2, 1.8, 1.6))
    val caja = Caja(sofa, Dimension(6.0, 2.0, 1.8))
    val caja2 = Caja(Mesa("Brisa", 4, Dimension(2.5, 2.5, 1.7)), Dimension(3.0, 3.0, 2.0))

    /**
     * Pensemos que tenemos un inventario así que tenemos lo siguiente
     * */
    val mesaTipo1 = Mesa("Futura", 5, Dimension(2.8, 2.5, 2.5))
    val mesaTipo2 = Mesa("Brisa", 3, Dimension(2.5, 2.5, 1.7))
    val sofaTipo1 = Sofa("Praga", 3, Dimension(6.2, 2.8, 2.6))
    val sofaTipo2 = Sofa("Lisboa", 4, Dimension(6.1, 2.6, 2.7))
    val inventario = listOf(mesaTipo1, mesaTipo1, mesaTipo1, sofaTipo1, sofaTipo2, mesaTipo1, sofaTipo2, sofaTipo2, mesaTipo2)

    val numeroMesasTipo1 = numeroDeApariciones(mesaTipo1, inventario)

    println("Mesas de tipo1 en existencia: $numeroMesasTipo1")

    /**
     * Si no declaramos restricciones en nuestras clases, funciones genericos puede hacer un mal uso de las mismas
     * como en este ejemplo, están guardando un string en lugar de un mueble
     * */
//    val miCaja = Caja("sdasdsa", Dimension(1.8, 2.0, 3.0))
    val miCaja = Caja(sofa, Dimension(6.8, 5.0, 3.0))


    /**
     * Relaciones de herencia que se crea entre objetos genéricos-------------------------------------------------------
     * */
    val miAny: Any = "String en Any"
    val miString: String = "String"
    printAny(miAny)
    printAny(miString)
    val miAnyList = mutableListOf(miAny)
    val miStringList = mutableListOf(miString)
    printListAny(miAnyList)
//    printListAny(miStringList)
}

fun printAny(miObjeto: Any) {
    println(miObjeto)
}

fun printListAny(miList: MutableList<Any>) {
    for (x in miList) {
        println(x)
    }
}