package kotlin_avanzado.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
//    show()
   /* runBlocking {
        runAsynchronous().forEach {i->  println(i)}
    }

    runBlocking {
        launch {
            for (j in 1..3) {
                println("No estoy bloqueado $j")
                delay(1000)
            }
        }

        /**Recuperar los valores que se están transmitiendo*/
        firstFlow().collect { value-> println(value) }
    }*/

    runBlocking {
        println("Llamando Flow...")
        val flow = firstFlow()
        println("Collect...")
        flow.collect {value-> println(value)}
        println("Collect again...")
        flow.collect {value-> println(value)}
    }
}

fun show() {
//    listar().forEach { i-> println(i) }
    secuencia().forEach { i-> println(i) }
}

fun listar() = listOf(3,95,90,45)

fun secuencia(): Sequence<Int> = sequence {
    for (i in 1..3) {
        Thread.sleep(1000)
        yield(i)
    }
}

/**De forma asincrona*/
suspend fun runAsynchronous() = runBlocking {
    delay(1000)
    return@runBlocking listOf(1, 2, 3)
}

/**Primer flow*/
fun firstFlow(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}