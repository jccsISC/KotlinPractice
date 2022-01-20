package kotlin_avanzado.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

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
    }

    runBlocking {
        println("Llamando Flow...")
        val flow = firstFlow()
        println("Collect...")
        flow.collect {value-> println(value)}
        println("Collect again...")
        flow.collect {value-> println(value)}
    }

    runBlocking {
        withTimeoutOrNull(2500) {
            firstFlow().collect {value-> println(value)}
        }
        println("Finalizado")
    }*/

    runBlocking {
//        secondFlow().collect {value-> println(value)}
        thirdFlow().collect {value-> println(value)}
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

fun secondFlow(): Flow<Int> = flowOf(1,2,3) //flowOf nos permite devolver cualquier cosa

fun thirdFlow(): Flow<Int> = (1..3).asFlow()