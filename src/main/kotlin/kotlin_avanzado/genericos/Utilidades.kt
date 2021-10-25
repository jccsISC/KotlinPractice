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
 * Funcion que nos permita hacer la suma de una lista de elementos
 * es generica pero con la restriccion de que solo con cualquier lista
 * de objetos de tipo Number (Int, Long, Double...)
 * */
/*fun <T: Number> List<T>.sum(): T {

}*/

/**
 * Nos devuelve el penultimo de una lista
 * */
val <T> List<T>.penultimo: T
get() = this[size -2]

/**
 * Funcion generica, con varias restricciones, con el where podemos
 * agregar todas las restricciones que sean necesarias
 * */
fun <T> foo(miParametro: T) where T: Any, T: Comparable<T> {

}