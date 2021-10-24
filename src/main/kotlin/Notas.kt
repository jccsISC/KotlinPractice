fun mainNotas() {

    /**
     * [Modificadores de visibilidad en kotlin]
     *
     * Los modificadores de visibilidad en kotlin son muy parecidos a los de java, con la diferencia que todo0 en kotlin
     * es público, a menos que definas que no debe serlo.
     *
     * public: es visible desde todos lados
     * protected: es visible solo para clases "hijas" de una clase
     * private: es visible solo dentro de la misma clase
     * internal: es visible solo dentro del mismo modulo.
     *
     *
     * [Modificadores de acceso]
     *
     * final: es usado por defecto en las clases y no puede ser sobre escrito
     * open: puede ser sobre escrito y debe ser explicítamente escrito
     * abstract: debe ser sobre escrito, este solo debe ser usado en clases abstractas, los miembros de la clase marcados
     *          como abstractos no pueden tener una implementación.
     *
     *
     * [Interfaces]
     *
     * Son clases en las cuales por defecto todos sus metodos son públicos y estan abiertos para ser sobre escritos. En
     * las interfaces, normalmente tenemos un método sin cuerpo, es decir métodos que carecen de implementación, pero
     * también se pueden tener métodos que tengan cuerpo, tal como para en java 8.
     *
     * Ojo: Si las interfaces pueden tener métodos con cuerpo, que pasa con las clases abstractas? pues las clases
     *      abstractas aun existen y la diferencia principal es que básicamente las clases pueden mantener un estado,
     *      mientras que las interfaces no pueden hacerlo. También debemos tomar en cuenta que la herencia se mantiene
     *      tal como en java, no se puede hacer herencia múltiple de clases, pero si de interfaces. Se entiende que el
     *      perimitir que los métodos de las interfaces tengan cuerpo, es con el objetivo de no repetir código que también
     *      pidría estar definido en la clase (interface en este caso) que define el método.
     *
     *
     * [Modificadores de Herencia]
     * Por defecto en kotlin no pueden ser heredadas, es decir, por defecto son clases final. Esto con el hecho de evitar
     * el problema que existe en java, que todas las clases pueden ser heredadas y esto a veces lleva a comportamientos
     * no esperados. Kotlin pretende evitar este problema, haciendo que por defecto las clases no puedan ser heredadas.
     *
     *
     * */

}