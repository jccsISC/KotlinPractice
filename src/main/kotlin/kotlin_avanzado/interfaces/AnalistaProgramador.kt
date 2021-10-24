package kotlin_avanzado.interfaces

/**
 * Para estos ejemplos de interface surge el problema diamante.
 * Supongamos que tenemos una clase que implemente las dos interfaces que a su
 * vez implementan a al interface Empleado, las cuales son Programador y Analista
 * */
class AnalistaProgramador: Programador, Analista {

    override fun trabajar() {
        super<Analista>.trabajar()
        super<Programador>.trabajar()
    }

    /**
     * De esta forma, el método trabajar, ejecutará el código de las dos clases "padres" de AnalistaProgramador,
     * y también como se habrán dado cuenta, no exige la implementación de el otro método, el cual está implementado
     * en la interface empleado. No es necesario hacer las dos llamadas, puede ser una o incluso ninguna, pero
     * el mérodo trabajar debe tener su porpia implementación.
     * */
}