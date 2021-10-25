package kotlin_avanzado.genericos

class Caja<T: Mueble>(var mueble: T, val dimension: Dimension) {

    init {
        /**
         * Lanzaremos una excepcion si las dimenciones del mueble son mayores que la caja
         * */
        val dimensionMueble = mueble.dimenciones
        if (dimensionMueble.x > dimension.x || dimensionMueble.y > dimension.y || dimensionMueble.z > dimension.z) {
            throw IllegalArgumentException("El mueble es mayor que la caja")
        }
    }

}
