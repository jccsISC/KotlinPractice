package kotlin_avanzado.genericos

/**
 * Funcion que nos cuente el numero de objetos de un determinado tipo que tenemos en el inventarios
 * Lo primero que hacemos es declarar los parametros de tipo que queremos usar.
 * */
fun <T> numeroDeApariciones(objeto: T, lista: List<T>): Int {

    val x: T
    return lista.count { it == objeto }

}

/**
 * Nos devuelve el penultimo de una lista
 * */
val <T> List<T>.penultimo: T
get() = this[size -2]