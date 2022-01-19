package kotlin_avanzado.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
//    show()
    runBlocking {
        runAsynchronous().forEach {i->  println(i)}
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