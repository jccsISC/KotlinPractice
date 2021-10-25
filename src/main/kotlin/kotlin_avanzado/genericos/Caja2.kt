package kotlin_avanzado.genericos

/**
 * Para ejemplo de covarianza y contravarianza
 * */
class Caja2<out T>(val objeto: T) {

    /**
     * Con el tipo out decimos que nuestra función solo devolverá el tipo T pero no será consumido
     * */
//    fun cambiarObjeto(otroObjeto: T) {
//        objeto = otroObjeto
//    }

    fun obtenerObjeto() = objeto
}
