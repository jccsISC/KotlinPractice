package kotlin_avanzado.interfaces

interface Empleado {

    /**
     * Método habitual sin cuerpo
     * */
    fun trabajar()

    /**
     * Método con cuerpo ya que se necesita hacer este código en cada clase que se implementa, por lo tanto para no
     * dúplicar código se hace desde aquí.
     * En otras palabras la implementación de este método se hace aquí mismo.
     * */
    fun registrarHoraSalida(hora: Int) = print("Mi hora de salida fue a las: $hora")
}