package kotlin_avanzado.interfaces

interface Programador: Empleado {
    override fun trabajar() = println("Me siento frente al computador y creo soluciones")
}
