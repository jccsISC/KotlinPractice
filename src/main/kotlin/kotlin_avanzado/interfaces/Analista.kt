package kotlin_avanzado.interfaces

interface Analista: Empleado {
    override fun trabajar() = print("Yo trato con los clientes")
}